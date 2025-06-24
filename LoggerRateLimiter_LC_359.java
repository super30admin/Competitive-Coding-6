/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time complexity - O(1) - look up for messages
Space Complexity - O(m) - to store m messages
 */
import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter_LC_359 {
    Map<String, Integer> logMap;

    public LoggerRateLimiter_LC_359() {
        logMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (logMap.containsKey(message)) {
            int interval = logMap.get(message); //1
            if (timestamp < interval + 10) {
                return false;
            } else {
                logMap.put(message, timestamp);
                return true;
            }
        } else {
            logMap.put(message, timestamp);
        }
        return true;
    }
}