// Time Complexity : O(1)
// Space Complexity : O(m) where m is the number of unique messages
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Approach - HashMap is used to store the logger messages and the corresponding latest time stamps. Before printing the logger message, it is checked in the hashmap to ensure the message was not printed latest by 10 secs.

import java.util.HashMap;

class LoggerRateLimitter {

    HashMap<String, Integer> messageTimestamps;

    public LoggerRateLimitter() {
        messageTimestamps = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamps.containsKey(message)
                || timestamp - messageTimestamps.get(message) >= 10) {
            messageTimestamps.put(message, timestamp);
            return true;
        }

        return false;
    }

}
