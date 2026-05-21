// https://leetcode.com/problems/logger-rate-limiter/
// Time Complexity : O(1) on average for each call to shouldPrintMessage, as HashMap operations are generally O(1).
// Space Complexity : O(n) where n is the number of unique messages stored in the HashMap.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Logger {

    private HashMap<String, Integer> msgMap;

    public Logger() {
        msgMap = new HashMap<String, Integer>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!msgMap.containsKey(message)) {
            msgMap.put(message, timestamp);
            return true;
        } else {
            if (timestamp - msgMap.get(message) >= 10) {
                this.msgMap.put(message, timestamp);
                return true;
            }
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */