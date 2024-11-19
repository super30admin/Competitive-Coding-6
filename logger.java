// Time Complexity : O(1)
// Space Complexity : O(n) where is the unique message that we get in the input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Logger {

    HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            if(timestamp >= map.get(message)+10){
                map.put(message, timestamp);
                return true;
            }
            else { 
                return false;
            }
        }
        else{
            map.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */