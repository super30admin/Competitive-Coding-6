359. Logger Rate Limiter

TC O(1)
SC O(n)


//HAshmap

class Logger {
private:
    unordered_map<string, int> last_printed;
public:
    Logger() {
    }
    
    bool shouldPrintMessage(int timestamp, string message) {
        // if the message is coming for the 1st time, print
        if(!last_printed.count(message)) {
            last_printed[message] = timestamp;
            return true;
        }
        else {
            int elapsed = timestamp - last_printed[message];
            if(elapsed >= 10)
                last_printed[message] = timestamp;
            return elapsed >= 10;
        }
    }
};


TC O(N)
SC O(N)
#define GAP 10
 class Logger { 
     // Queue+Set. Better than the one in the sol tab. O(N) O(N). Most production ready approach because the set of stored messages will not blow up. And better than the ones in the discussions tab because the queue has a direct iterator to the corresponding unordered_set item, which eliminates the need to calculate the hash of the input message multiple times
private:
    unordered_set<string> msgs;
    queue<pair<unordered_set<string>::iterator, int>> queue;
    void cleanup_queue(int timestamp) {
        while(!queue.empty() && queue.front().second <= timestamp) {
            msgs.erase(queue.front().first);
            queue.pop();
        }
    }
public:
    Logger() {
        
    }
    
    bool shouldPrintMessage(int timestamp, string message) {
        cleanup_queue(timestamp);
        auto p = msgs.insert(message);
        auto it = p.first;
        if(p.second)
            queue.emplace(it, timestamp + GAP);
        else
            return false;
        return true;
    }
};
