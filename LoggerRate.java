// Time Complexity : O(1) Just for the lookup of the particular incoming message
// Space Complexity : O(n) for storing all the messages,timestamp in hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Used Hashing to store the timestamp of respective message string
// the next timestamp will be compared with the previously stored timestamp of respective message from dictionary

class Logger {
    HashMap<String,Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            if(map.get(message) <= timestamp){
                map.put(message,timestamp+10);
                return true;
            }
            else
                return false;
        }
        else{
            map.put(message,timestamp+10);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
