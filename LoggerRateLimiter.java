
// Time Complexity : O(1)
// Space Complexity : O(n) n messages
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Using HashMap
class Logger {
    
    private Map<String, Integer> msgMap;

    /** Initialize your data structure here. */
    public Logger() {
        msgMap = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!msgMap.containsKey(message)){
            msgMap.put(message, timestamp);
            return true;
        }
        
        int oldTimstamp = msgMap.get(message);
        if(timestamp - oldTimstamp >=10){
            msgMap.put(message, timestamp);
            return true;
        }else{
            return false;
        }
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */