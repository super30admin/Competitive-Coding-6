
// Time Complexity : O(1)
// Space Complexity :  O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Logger {
    HashMap<String,Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            if(timestamp - map.get(message) >= 10){
                map.put(message,timestamp);
                return true;
            }else{
                return false;
            }
        }else{
            map.put(message,timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
