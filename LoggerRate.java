// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

import java.util.HashMap;

public class LoggerRate
{
    private HashMap<String, Integer> messageTime;

    public LoggerRate() {
        messageTime = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTime.containsKey(message) || timestamp - messageTime.get(message) >= 10) {
            messageTime.put(message, timestamp);
            return true;
        }
        return false;
    }
}
