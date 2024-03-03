// https://leetcode.com/problems/logger-rate-limiter/description/

// Time Complexity : O(1) for shouldPrintMessage
// Space Complexity : O(No. of Unique Logs) --> O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Store mappings of when a particular log was last received
// When it is received again, compare with the timestamp already stored 
// Used a HashMap to optimise search and mapped logMessage to timeStamp received

class Logger {
    private Map<String, Integer> logs;

    public Logger() {
        this.logs = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        // Check if message not in map
        if(!logs.containsKey(message)){
            logs.put(message, timestamp);
            return true;
        }

        // If message was already stored in logs
        int lastTimestamp=logs.get(message);

        // Printed more than 10 time units
        if((timestamp-lastTimestamp)>=10){
            logs.put(message, timestamp);
            return true;
        }

        // Printed less than 10 time units
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */