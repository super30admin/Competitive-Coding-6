// Time Complexity: O(1) for shouldPrintMessage and O(1) for Logger constructor
// Space Complexity: O(n) where n is the number of unique messages

import java.util.HashMap;
import java.util.Map;

class Logger {
    Map<String, Integer> map;

    public Logger() {
        this.map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }else{
            int prev = map.get(message);

            if(timestamp < (prev + 10)){
                return false;
            }
            map.put(message, timestamp);
        }
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */