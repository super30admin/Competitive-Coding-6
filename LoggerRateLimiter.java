class Logger {

    /** Initialize your data structure here. */
    HashMap<String, Integer> hm;
    public Logger() {
         hm = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(hm.containsKey(message)){
            int t = hm.get(message);
            if((timestamp-t<10))
                return false;
            else
               hm.put(message, timestamp);
        }
        else{
            hm.put(message, timestamp);
        }
        return true;
    }
}

//Time complexity : O(1) 
//Space complexity : O(N) where N is the number of incoming messages

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
