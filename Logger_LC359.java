// Time complexity: O(1) — lookup and update in HashMap.
// Space complexity: O(n) — where n is the number of unique messages in memory.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.HashMap;

class Logger_LC359 {

    HashMap<String, Integer> map;

    public Logger_LC359() {
       this.map = new HashMap<>();
    }

    
    public boolean shouldPrintMessage(int timestamp, String message) {
        int lastTimePrinted = map.getOrDefault(message, -10);

        if (timestamp - lastTimePrinted >= 10) {
            map.put(message, timestamp);
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