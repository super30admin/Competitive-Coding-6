// https://leetcode.com/problems/logger-rate-limiter/description/
// Time Complexity : O(1) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Logger {
    public:
        Logger() {
            
        }
        unordered_map<string,int> mp;
        bool shouldPrintMessage(int timestamp, string message) {
            if(mp.find(message) != mp.end()){
                if(timestamp < 10+mp[message]) return false;
            }
            mp[message] = timestamp;
            return true;
                
        }
    };
    
    /**
     * Your Logger object will be instantiated and called as such:
     * Logger* obj = new Logger();
     * bool param_1 = obj->shouldPrintMessage(timestamp,message);
     */