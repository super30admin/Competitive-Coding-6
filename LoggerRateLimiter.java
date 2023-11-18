// Time Complexity : O(1)
// Space Complexity : O(N), where N is size of all incoming messages
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class LoggerRateLimiter {
    HashMap<String, Integer> map;

    public LoggerRateLimiter() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean flag = true;
        if (!map.containsKey(message)) {
            map.put(message, timestamp + 10);
            flag = true;
        } else {
            if (map.get(message) > timestamp) {
                flag = false;
            } else {
                map.put(message, timestamp + 10);
            }
        }
        return flag;
    }
}