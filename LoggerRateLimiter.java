/* Time Complexity :O(1)
 * Space Complexity :O(M), M => size of all incoming messages
 * Did this code successfully run on Leetcode :yes
 * Any problem you faced while coding this :No
 */

import java.util.HashMap;

class Logger {
    HashMap<String, Integer> map;
    public Logger() {
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

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */ 