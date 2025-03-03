import java.util.HashMap;

// https://leetcode.com/problems/logger-rate-limiter/

// Time Complexity: O(1) for shouldPrintMessage and O(1) for Logger constructor
// Space Complexity: O(n) where n is the number of unique messages

class LoggerRateLimiter {

    HashMap<String, Integer> map;

    public LoggerRateLimiter() {
        map = new HashMap();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        if(!map.containsKey(message)) {
            map.put(message, timestamp);

            return true;
        } else {

            int oldTimestamp = map.get(message);

            if(timestamp >= oldTimestamp + 10) {
                map.put(message, timestamp);

                return true;
            }

            return false;
        }


    }
}