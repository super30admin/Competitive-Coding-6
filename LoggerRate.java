class Logger {

    /** Initialize your data structure here. */
    
    HashMap<String, Integer> logger;
    public Logger() {
        this.logger = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        //check if message present in looger
        if(logger.containsKey(message)){
            
            //get its last timestamp
            int oldtime = logger.get(message);
           
            //check the difference
            if(timestamp - oldtime >= 10){
                logger.put(message, timestamp);
                return true;
            }
            
        }else{
            logger.put(message,timestamp);
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