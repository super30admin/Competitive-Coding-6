/**
 * Space complexity is number of unique log messages
 * time complexity is O(1)
 */
import java.util.HashMap;
import java.util.Map;

class Logger {
    
    Map<String, Integer> logs;

    public Logger() {
        logs = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!logs.containsKey(message) || (logs.containsKey(message) && (timestamp - logs.get(message)) >= 10) ) {
            logs.put(message, timestamp);
            return true;
        }
        return false;
    }
}