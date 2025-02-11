//TC: O(1)
//SC: O(n) where n is no of unique messages
//approach: hashing

import java.util.HashMap;
import java.util.Map;

class Logger {
    private Map<String, Integer> msgMap;

    public Logger() {
        msgMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!msgMap.containsKey(message) || timestamp - msgMap.get(message) >= 10) {
            msgMap.put(message, timestamp);
            return true;
        }
        return false;
    }
}


