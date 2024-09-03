
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Logger {
    private Map<String, Integer> messageTimestampMap;

    public Logger() {
        messageTimestampMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestampMap.containsKey(message)) {
            // If the message hasn't been seen before, log it and store the timestamp
            messageTimestampMap.put(message, timestamp);
            return true;
        } 
        
        int lastTimestamp = messageTimestampMap.get(message);
        
        if (timestamp - lastTimestamp >= 10) {
            // If 10 seconds have passed since the last log, log the message again
            messageTimestampMap.put(message, timestamp);
            return true;
        }
        
        // Otherwise, do not log the message
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
