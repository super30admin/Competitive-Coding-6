// Time Complexity : O(n) n is the message length
// Space Complexity : O(n) size of map to store messages.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class Logger {
    HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            int time = map.get(message);
            if(timestamp-time>=10){
                map.put(message, timestamp);
                return true;
            }
            else{
                return false;
            }
        }
        else{
            map.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */