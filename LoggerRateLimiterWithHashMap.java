// Time Complexity : O(1)
// Space Complexity : O(n) ->space of HashMap
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;

public class LoggerRateLimiterWithHashMap {
    HashMap<String, Integer> map;
    public LoggerRateLimiterWithHashMap() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int prevTimeStamp;
        if(map.containsKey(message))
        {
            prevTimeStamp = map.get(message);
            if(timestamp < prevTimeStamp+10)
                return false;
        }
        map.put(message,timestamp);
        return true;
    }

}
