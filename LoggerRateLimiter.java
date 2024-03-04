import java.util.HashMap;
import java.util.Map;

// TC - O(1)
// SC - O(N)

public class LoggerRateLimiter {
    class Logger {
        Map<String, Integer> msgToTimeMap;

        public Logger() {
            msgToTimeMap = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!msgToTimeMap.containsKey(message)) {
                msgToTimeMap.put(message, timestamp);
                return true;
            }
            if (msgToTimeMap.containsKey(message)) {
                if (timestamp - msgToTimeMap.get(message) >= 10) {
                    msgToTimeMap.put(message, timestamp);
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
}
