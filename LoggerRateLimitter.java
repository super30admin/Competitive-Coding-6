// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Using hashmap to keep track of the time to wait. Fetching the current log time from HM of the message and adding to the Hm if not present.
import java.util.HashMap;

public class LoggerRateLimitter {
    private HashMap<String, Integer> logMap;
    private int timeToWait;

    public LoggerRateLimitter() {
        logMap = new HashMap<String, Integer>();
        timeToWait = 10;
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer curLogTime = logMap.get(message);
        if(curLogTime == null || (timestamp - curLogTime) >= this.timeToWait) {
            logMap.put(message, timestamp);
            return true;
        }
        return false;
    }
}

