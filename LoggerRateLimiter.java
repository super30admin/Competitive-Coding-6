//Time complexity: O(1)
//Space complexity: O(N), where N is the number of messages

import java.util.*;

class Logger {
    HashMap<String, Integer> map; 
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>(); 
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message) || map.get(message) <= timestamp) {
            map.put(message, timestamp+10);
            return true; 
        }
        return false;
    }
}