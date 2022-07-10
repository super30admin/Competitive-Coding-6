import java.util.*;

class Logger {
    // map for storing message and it timeStamp
    private HashMap<String, Integer> map;

    public Logger() {
        // initialize data structure
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        // check if message is not contains in the map then insert it into map and
        // return true as we dont need to check if it is already printed in last 10
        // seconds
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        } else {
            // else check if it is already printed in the last 10 second return false else
            // update timestamp of the message and return true
            int prevTime = map.get(message);
            if ((prevTime + 10) <= timestamp) {
                map.put(message, timestamp);
                return true;

            } else {
                return false;

            }
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo")); // return true, next allowed timestamp for "foo" is 1 +
                                                                 // 10 = 11
        System.out.println(logger.shouldPrintMessage(2, "bar")); // return true, next allowed timestamp for "bar" is 2 +
                                                                 // 10 = 12
        System.out.println(logger.shouldPrintMessage(3, "foo")); // 3 < 11, return false
        System.out.println(logger.shouldPrintMessage(8, "bar")); // 8 < 12, return false
        System.out.println(logger.shouldPrintMessage(10, "foo")); // 10 < 11, return false
        System.out.println(logger.shouldPrintMessage(11, "foo")); // 11 >= 11, return true, next
    }
}