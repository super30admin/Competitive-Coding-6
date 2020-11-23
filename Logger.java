package S30.CompetitiveCoding_6;

import java.util.HashMap;


/*
Time Complexity : O(1)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

class Logger {

    HashMap<String,Integer> map = null;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {

        if(map.containsKey(message)){
            int lastTime = map.get(message);
            if(timestamp - lastTime >= 10){
                map.put(message,timestamp);
                return true;
            }
            return false;
        }else{ //if seeing message for first time, always return true
            map.put(message,timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
