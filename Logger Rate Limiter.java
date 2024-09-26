//Time Complexity : O(1)
//Space Complexity : O(N). N is the total number of incoming messages.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english:
/*
Use a hashmap to store all the incoming messages as key and timestamp as its value.
If the message is coming for the first time add it to the map along with its timestamp +10. If its alreay available, compare the newtimestamp and oldtimestamp.
If the new one is greater then return true and update the new timestamp. otherwise return false.
 */
// Your code here along with comments explaining your approach
class Logger {
     HashMap<String,Integer> timemap;
    /** Initialize your data structure here. */
    public Logger() {
        timemap = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!timemap.containsKey(message)){
            timemap.put(message,timestamp+10);
            return true;
        }
        //if the message is appearing for the second time, check its previoustime
        Integer oldtime = timemap.get(message);
        //if its greater than 10 then return true
        if(timestamp >= oldtime){
            //update the new time
            timemap.put(message,timestamp+10);
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