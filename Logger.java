// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
import java.util.Map;
import java.util.HashMap;

public class Logger {

    Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)) {
            map.put(message, timestamp + 10);
            return true;
        }else if(map.get(message) <= timestamp) {
            map.put(message, timestamp + 10);
            return true;
        }else{
            return false;
        }
    }
}
