// Time Complexity : O(l) where l = length of string to be hashed and stored; approx O(1)
// Space Complexity : O(n) - hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Using a hashmap to store string with timestamp; if the same string
// is passed again, check if last timestamp is within 10 seconds or not.

import java.util.HashMap;
import java.util.Map;

class Logger {
    Map<String, Integer> map;

    public Logger() {
        map = new HashMap();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }
        // map contains key
        if (timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}