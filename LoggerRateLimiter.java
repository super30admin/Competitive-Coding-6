// The time complexity of this implementation is O(1)
import java.util.*;

class LoggerRateLimiter {
    private Map<String, Integer> messageDict;

    public void Logger() {
        messageDict = new HashMap<String, Integer>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageDict.containsKey(message)) {
            messageDict.put(message, timestamp);
            return true;
        }

        int oldTimestamp = messageDict.get(message);
        if (timestamp - oldTimestamp >= 10) {
            messageDict.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();

        // prints true
        System.out.println(logger.shouldPrintMessage(1, "foo"));

        // prints true
        System.out.println(logger.shouldPrintMessage(2, "bar"));

        // prints false because "foo" was printed less than 10 seconds ago
        System.out.println(logger.shouldPrintMessage(3, "foo"));

        // prints false because "bar" was printed less than 10 seconds ago
        System.out.println(logger.shouldPrintMessage(8, "bar"));

        // prints true because 10 seconds have passed since "foo" was last printed
        System.out.println(logger.shouldPrintMessage(12, "foo"));

        // prints true because "bar" was not printed again since the last call
        System.out.println(logger.shouldPrintMessage(15, "bar"));
    }

}
