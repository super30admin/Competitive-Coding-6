// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * 1. Maintain a hashmap with message as key and timestamp as value.
 * 2. If message is not present in map, add it to map and return true.
 * 3. If message is present in map, check if timestamp is greater than or equal to value in map.
 */

import java.util.HashMap;

class Logger {
    HashMap<String, Integer> map;

    public Logger() {
        this.map = new HashMap<>();    
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp+10);
            return true;
        }

        if(map.get(message) <= timestamp){
            map.put(message, timestamp+10);
            return true;
        }
        
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */