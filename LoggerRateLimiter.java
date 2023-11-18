// Time Complexity :O(1)
// Space Complexity :O(n) where n is number of unique strings that will be passed to the shouldPrintMessage() call
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
import java.util.HashMap;
public class LoggerRateLimiter {
    class Logger {
        private HashMap<String, Integer> logHistoryMap;

        public Logger() {
            this.logHistoryMap = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {

            if (!logHistoryMap.containsKey(message)) {
                logHistoryMap.put(message, timestamp);
                return true;
            }

            int lastTimeStamp = logHistoryMap.get(message);
            //update the map if needed
            if (timestamp >= lastTimeStamp + 10) {
                logHistoryMap.put(message, timestamp);
                return true;
            }
            return false;
        }
    }
}
