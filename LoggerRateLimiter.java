package competitiveCoding6;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
	//Time Complexity : O(1)
	//Space Complexity : O(n), where n is the size of all incoming messages
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	Map<String, Integer> map;
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)) {
            int time = map.get(message);
            if(timestamp >= time + 10) {
                map.put(message, timestamp);
                return true;
            }
            return false;
        } else {
            map.put(message, timestamp);
        }
        
        return true;
    }
}
