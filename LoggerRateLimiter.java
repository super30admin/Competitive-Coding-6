// Time Complexity : O(1)
// Space Complexity : O(N) , number of messages
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Have a hashmap to store each incoming message along with their respective timestamp. Now, if we see any duplicate
message coming within an interval of its initial recorded time + 10 seconds, we return false, as asked in the
question. If not, we update/add that message with the new timestamp in the map and return true.
 */
class Logger {
    Map<String, Integer> map;
    public Logger() {
        this.map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)) {
            int currentTime = map.get(message);
            if(timestamp  < currentTime + 10)
                return false;
        }
        map.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
