// Time Complexity : O(1) for shouldPrintMessage()
// Space Complexity : O(M), M is #incoming messages
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// we use a hashmap to keep track of the messages and their incoming times
// if timestamp-prevtime<10 return false
// else return true
// if not exists in map then put and return true

class Logger {

    /** Initialize your data structure here. */
    HashMap<String, Integer> map;
    
    public Logger() {
        map = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            if(timestamp-map.get(message)<10){
                return false;  
            } 
            else{
                map.put(message, timestamp);
                return true;
            } 
        }
        else{
            map.put(message, timestamp);
            return true;
        }
    }
}