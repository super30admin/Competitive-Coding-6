
// Time Complexity: O(1) for each message processing
// Space Complexity: O(M) where M is the number of unique messages

// We use a HashMap to store the last timestamp of each message
// When a new message comes in, we check if it exists in the map    
// If it exists, we check if the current timestamp is at least 10 seconds greater than the last timestamp
// If it does, we update the timestamp and return true
// If it doesn't, we return false

class Logger {
    HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int prevTimeStamp;
        if (map.containsKey(message)) {
            prevTimeStamp = map.get(message);
            if (timestamp < prevTimeStamp + 10) {
                return false;
            }
        }
        map.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp, message);
 */
