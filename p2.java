// Time Complexity : shouldPrintMessage O(1)
// Space Complexity : shouldPrintMessage O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



class Logger {
    //Hashmap to keep track of message and it's timestamp
    Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        //Check if message is already there or not
        
        if(map.containsKey(message)){
            int val = map.get(message);
        //Check if it satisfies our timestamp requirement
        //if it does, update timestamp and return true    
            if(timestamp >= val+10){
                map.put(message, timestamp);
                return true;
            }
            else return false;
        }

        //if the message is not there then put the message
        map.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */