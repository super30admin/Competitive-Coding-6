// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Logger {
    
    Map<String, Integer> rateMap;

    /** Initialize your data structure here. */
    public Logger() {
        rateMap = new HashMap();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(rateMap.containsKey(message)) {
            
            int time = rateMap.get(message);
            if(timestamp < (time+10)) {
                return false;
            } else {
                rateMap.put(message, timestamp);
                return true;
            }
            
        } else {
            rateMap.put(message, timestamp);
            
        }
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

// f0o -1  , bar - 2 

// 1-n permutations
// 1,2
