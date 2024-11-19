// Time Complexity :O(1)
// Space Complexity :O(number of unique entries)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Logger {
    HashMap<String, Integer> logmap;
    /** Initialize your data structure here. */
    public Logger() {
        logmap= new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(logmap.containsKey(message)){
            if(logmap.get(message)>=timestamp)//check if limit of timestamp is within message's timestamp
                return false;
            else{
                logmap.put(message,timestamp+9);//add the max limit of timestamp for any message
                return true;
            }
            
        }
        logmap.put(message,timestamp+9);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */