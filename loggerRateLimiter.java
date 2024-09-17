//time complexity: O(1) ;searching for a message and adding a message in a hashmap is O(1)
//space complexity: O(n) where n is the number of unique messages
//executed on leetcode: yes
//approach: we use a hashmap to store the messages and their timestamps
// if a message appears for the first time, we add an entry to the hashmap
//if a message appears less than or equal to 10 seconds, we update the hashmap and return true
// else we return false

class Logger {
    HashMap<String,Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<String,Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message))
        {
            map.put(message,timestamp);
        }
        else
        {
            if(timestamp-map.get(message)>=10)
            {
                map.put(message,timestamp);
            }
            else
            {
                return false;
            }
        }
        
        return true;
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */