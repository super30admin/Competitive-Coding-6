import java.util.HashMap;
import java.util.Map;

//TC will be O(1)
//SC will be O(1)

class LoggerProb {
    private Map<String, Integer> messageTimestamps;

    public LoggerProb() {
        messageTimestamps = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamps.containsKey(message) || timestamp - messageTimestamps.get(message) >= 10) {
            // If the message is not in the map or the last printed time is more than 10 seconds ago, print the message.
            messageTimestamps.put(message, timestamp);
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        LoggerProb logger = new LoggerProb();

        System.out.println(logger.shouldPrintMessage(1, "foo")); // true
        System.out.println(logger.shouldPrintMessage(2, "bar")); // true
        System.out.println(logger.shouldPrintMessage(3, "foo")); // false
        System.out.println(logger.shouldPrintMessage(8, "bar")); // false
        System.out.println(logger.shouldPrintMessage(10, "foo")); // false
        System.out.println(logger.shouldPrintMessage(11, "foo")); // true
    }
}
