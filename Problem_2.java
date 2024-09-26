// Time Complexity : O(n) where n is the length of the input
// Space Complexity : O(k) where k is the number of distinct messages
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

import java.util.HashMap;

class Logger {
    HashMap<String, Integer> map;

    public Logger() {
        this.map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        // Check if the message is present in the map
        if (this.map.containsKey(message)) {
            // Check the timestamp associated with map
            if (timestamp >= this.map.get(message)) {
                this.map.put(message, timestamp + 10);
                return true;
            } else
                return false;
        } else {
            this.map.put(message, timestamp + 10);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */