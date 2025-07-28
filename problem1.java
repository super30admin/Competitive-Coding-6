// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Approach : I use a HashMap to store the last time a message was printed. When a new message comes in, I check if it can be printed based on the timestamp and update the map accordingly.

class Logger {
    HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        int time = map.containsKey(message)?map.get(message):0;
        if(time<=timestamp){
            map.put(message, timestamp+10);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */