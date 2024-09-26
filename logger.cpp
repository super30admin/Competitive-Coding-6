//TC: O(1)
//SC: O(M) where M is all messages received

class Logger {
public:
    /** Initialize your data structure here. */
    
    unordered_map<string, int> logmap;
    
    Logger() {
    
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    bool shouldPrintMessage(int timestamp, string message) {
        
        if(logmap.find(message)!=logmap.end()){
            int currentTime = logmap[message];
            if(timestamp - currentTime >=10){
                logmap[message] = timestamp;
                return true;
            } else{
                return false;
            }
            
        } else{
            logmap[message] = timestamp;
            return true;
        }
        
        
    }
};

/**
 * Your Logger object will be instantiated and called as such:
 * Logger* obj = new Logger();
 * bool param_1 = obj->shouldPrintMessage(timestamp,message);
 */