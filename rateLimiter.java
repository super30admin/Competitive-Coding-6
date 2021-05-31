//Time complexity O(1)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Logger {

    /** Initialize your data structure here. */
    HashMap<String,Integer> map1;
    
    public Logger() {
        
          map1 = new HashMap<>(); 
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
         if(!map1.containsKey(message)){
            
            map1.put(message, timestamp);
             return true;
        }
        
        else {
            
            int tempTime = map1.get(message);
            
            if(timestamp - tempTime >= 10){
                map1.put(message, timestamp);
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */