//Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Logger {
public:
    /** Initialize your data structure here. */
    map<string, int> m;
    Logger() {
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    bool shouldPrintMessage(int timestamp, string message) {
        if(m.find(message)==m.end()){
            m[message]=timestamp;
            return true;
        }
        else{
            int diff = timestamp-m[message];
            if(diff>=10){
                m[message]=timestamp;
                return true;
            }
        }
        return false;
    }
};
