//Time complexity=O(1), For searching in hashMap and Updating it
//Space Complexity=O(N), No. of incoming messages

class Logger {
    HashMap<String,Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map=new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message))
        {
            int temp=map.get(message);
            if(timestamp-temp<10)//Checks if the message is sent within 10 seconds then return null
                return false;
        }
        map.put(message,timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */