// Time Complexity :O(nlogn) where n is the entries removed from heap
// Space Complexity : O(k) Size of the heap/hashmap  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Logger {
    
public:
    /** Initialize your data structure here. */
    unordered_map<string,int> hMap;
    priority_queue<pair<int,string>,vector<pair<int,string>>,greater<pair<int,string>>> pq;
    
    void update(int timestamp){
        while(pq.size() && pq.top().first <= timestamp){
            auto [time,msg] = pq.top();
            pq.pop();
            hMap.erase(msg);
        }
    }
    Logger() {
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    bool shouldPrintMessage(int timestamp, string message) {
        update(timestamp-10);
        if(hMap.find(message) == hMap.end()){
            hMap[message] = timestamp;
            pq.push({timestamp,message});
            return true;
        }
        return false;
    }
};

/**
 * Your Logger object will be instantiated and called as such:
 * Logger* obj = new Logger();
 * bool param_1 = obj->shouldPrintMessage(timestamp,message);
 */