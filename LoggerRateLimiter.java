import java.util.HashMap;

public class LoggerRateLimiter {
    HashMap<String, Integer> msgMap;

    public LoggerRateLimiter() {
        this.msgMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (msgMap.containsKey(message) && timestamp - msgMap.get(message) < 10) {
            return false;
        }

        msgMap.put(message, timestamp);

        return true;
    }
}

//TC: O(1), SC: O(n)

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
