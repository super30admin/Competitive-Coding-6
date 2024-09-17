// TC - O(1)
// SC - O(N) where N is size of all incoming messages
// Leetcode URL : https://leetcode.com/problems/logger-rate-limiter/

import java.util.HashMap;

public class LoggerRateLimiter {
    HashMap<String, Integer> map;
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean flag = true;
        if(!map.containsKey(message)){
            map.put(message, timestamp+10);
            flag = true;
        }else{
            if(map.get(message) > timestamp) {
                flag = false;
            }else{
                map.put(message, timestamp+10);
            }
        }
        return flag;
    }
}
