class Logger {

    /** Initialize your data structure here. */
    Map<String, Integer> logMap; 
    public Logger() {
        logMap = new HashMap<>();       //Map<Message, timestamp>
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!logMap.containsKey(message)) {
            logMap.put(message, timestamp);             // if map doesn't contain message, add to it along with timestamp
            return true;
        }
        else {
            int prevTimeStamp = logMap.get(message);   // calculate previous time stamp
            if(timestamp - prevTimeStamp >= 10) {   // if difference of curr and prev timestamps is more than 10, can print, so update timestamp
                logMap.put(message, timestamp);        // if difference less than 10, return false
                return true;
            }
            else 
                return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */