
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Logger {
  HashMap<String,Integer> logger =new HashMap<>();
    public Logger() {
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!logger.containsKey(message)){
           logger.put(message,timestamp) ;
           return true;
        }
        int loggerlasttime=logger.get(message);
        if(timestamp-loggerlasttime<10){
        return false;
        }
        else {
            logger.put(message, timestamp); 
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */