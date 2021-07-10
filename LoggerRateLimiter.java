//time Complexity - O(1)
//space complexity - O(n) // size of the incoming messages

class Logger {
    //map to keep track of message and timeStamp
    private HashMap<String, Integer>  map;

    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        //if the message is not arrived before
        if(!map.containsKey(message)) {
            map.put(message,timestamp);
            return true;
        }
        //if the the same message has recieved before 
        int oldTime = map.get(message);
        if(timestamp - oldTime >= 10) {
            //if time is greater than 10 log the message
            map.put(message,timestamp);
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */