import java.util.HashMap;

// Time Complexity :o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Logger {

    HashMap<String,Integer> hm;
    /** Initialize your data structure here. */
    public Logger() {
        hm=new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(!hm.containsKey(message))
        {
            hm.put(message,timestamp);
            return true;
        }
        else
        {
          int oldtime=hm.get(message);
            
            if(timestamp-oldtime >=10)
            {
                hm.put(message,timestamp);
                return true;
            }
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
