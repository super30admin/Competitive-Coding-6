// Time Complexity : O(n); where n = number of messages
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Logger {
    HashMap<String, Integer> map;
    public Logger() {
         map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        } 
        else{
            if(timestamp - map.get(message) >= 10){
                map.put(message, timestamp);
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