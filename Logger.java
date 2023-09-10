class Logger {
    HashMap<String, Integer> map;

    public Logger() {
       map = new HashMap<String, Integer>(); 
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!this.map.containsKey(message))
        {
            this.map.put(message,timestamp);
            return true;
        }
        int oldTimeStamp = this.map.get(message);
        
        if(timestamp - oldTimeStamp >= 10)
        {
            this.map.put(message,timestamp);
            return true;
        }
        return false;
    }
}

// Time Complexity : O(1) lookup in hasmap is order of 1
// Space Complexity : O(N) N is length of message
// Did this code successfully run on Leetcode :

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */