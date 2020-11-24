class Logger {
    private HashMap<String, Integer> msgDict;

    /**
     * Initialize your data structure here.
     */
    public Logger() {
        msgDict = new HashMap<String, Integer>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {

        if (!msgDict.containsKey(message)) {
            msgDict.put(message, timestamp);
            return true;
        }

        Integer oldTimestamp = msgDict.get(message);
        if (timestamp - oldTimestamp >= 10) {
            msgDict.put(message, timestamp);
            return true;
        } else
            return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */