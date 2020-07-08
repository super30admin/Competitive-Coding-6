// Time Complexity : O(1)
// Space Complexity : O(n) --> where n is number of input strings
// Did this code successfully run on Leetcode (359) : Yes 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.HashMap;

class Logger {
    HashMap<String, Integer> map = new HashMap<>();;
    /** Initialize your data structure here. */
    public Logger() {

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {

        if (map.containsKey(message)) {
            int lastTime = map.get(message);
            if (timestamp - lastTime >= 10) {
                map.put(message, timestamp);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            map.put(message, timestamp);
            return true;
        }

    }

    public static void main(String args[]) {
        Logger log = new Logger();
        System.out.println(log.shouldPrintMessage(1, "foo"));
        System.out.println(log.shouldPrintMessage(5, "foo"));
    }
}