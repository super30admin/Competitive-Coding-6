// Time Complexity : O(1) as hashtable takes O(1) for fetch and insert
// Space Complexity : O(n) where n is the number of unique msgs
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach: use hashmap for storing the msg and its timestamp

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    class Logger {

        // map for msg and timestamp
        Map<String, Integer> map;

        public Logger() {
            map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message)) {
                if (timestamp - map.get(message) < 10) {
                    return false;
                }
            }
            map.put(message, timestamp);
            return true;
        }
    }

    /**
     * Your Logger object will be instantiated and called as such:
     * Logger obj = new Logger();
     * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
     */
}
