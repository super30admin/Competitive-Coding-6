// Time Complexity : O(1)
// Space Complexity : O(N) where N is the number of unique keys
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Logger {
public:
    /** Initialize your data structure here. */
    map<string, int> hashmap;
    Logger() {
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    bool shouldPrintMessage(int timestamp, string message) {
        if(message == ""){
            return false;
        }
        if(hashmap.find(message)==hashmap.end()){
            hashmap.insert(pair<string,int>(message, timestamp));
            return true;
        }
        else{
            int diff = timestamp - hashmap[message];
            //hashmap[message] = timestamp;
            if(diff>=10){
                hashmap[message] = timestamp;
                return true;
            }
            else{
                return false;
            }
        }
    }
};

/**
 * Your Logger object will be instantiated and called as such:
 * Logger* obj = new Logger();
 * bool param_1 = obj->shouldPrintMessage(timestamp,message);
 */
