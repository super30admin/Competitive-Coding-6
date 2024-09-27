//https://leetcode.com/problems/logger-rate-limiter/
/*
Time: O(n)
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class LoggerRateLimiter {

    class Logger {

        HashMap<String, Integer> map;

        public Logger() {
            map = new HashMap<String, Integer>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {

            if (!map.containsKey(message)) {
                map.put(message, timestamp);
                return true;
            }

            int prev = map.get(message);

            if (timestamp - prev >= 10) {
                map.put(message, timestamp);
                return true;
            }

            return false;

        }
    }

}
