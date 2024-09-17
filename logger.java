// Time Complexity : O(1) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class Logger {

    HashMap<String,Integer> sMap;
    
    /** Initialize your data structure here. */
    public Logger() {
        sMap=new HashMap<String,Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(!sMap.containsKey(message)){
            sMap.put(message,timestamp);
            return true;
        }
        
        if(timestamp - (sMap.get(message)) >=10){
            sMap.put(message,timestamp);
            return true;
        }else
            return false;
        
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */