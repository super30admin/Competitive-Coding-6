// Time Complexity : O(1)
// Space Complexity : O(n) (for the HashMap data strucutre to store n logs)
// Did this code successfully run on Leetcode : Didn't try on LC, it's LC 
//      premium, tried elsewhere
// Any problem you faced while coding this : Yes, this problem is LC premium,
//      so cannot solve on LC.

/*
 * Approach
 * We use a HashMap in order to store the logs and the timestamps of those logs.
 * When the shouldPrintMessage function is called, it checks the incoming
 * timestamp against the currently present timestamp (if any) and then returns
 * the appropriate response.
 */

import java.util.*;

class Logger {

    HashMap<String, Integer> logs;

    /** Initialize your data structure here. */
    public Logger() {
        // key is the message and value is the latest time of that message
        logs = new HashMap<String, Integer>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer prevTime = logs.get(message);
        // if logs is not printed in last 10s
        if (prevTime == null || (timestamp - prevTime >= 10)) {
            logs.put(message, timestamp);
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