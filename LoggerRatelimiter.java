class LoggerRatelimiter {

    // Use hashmap to store logs and timestamp.
    // while adding it to hashmap increment a time by 10 and
    // next time check if stored timestamp is less than or equal to timestamp received.

    HashMap<String, Integer> logsMap;

    public LoggerRatelimiter() {
        logsMap  = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(logsMap.containsKey(message)){
            if(logsMap.get(message) <= timestamp){
                logsMap.put(message,timestamp+10);
                return true;
            }else{
                return false;
            }
        }else{
            logsMap.put(message,timestamp+10);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
