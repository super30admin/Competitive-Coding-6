class Logger {
    private Map<String, Integer> messageTime;

    public Logger() {
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

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
