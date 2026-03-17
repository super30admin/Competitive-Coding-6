// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;

class Logger {
    Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer prevTime = map.get(message);

        if (!map.containsKey(message) || timestamp - prevTime >= 10) {
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