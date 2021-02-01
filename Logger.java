
// Time Complexity : The time complexity is O(1)
// Space Complexity : The space complexity is O(n) where n is the number of unique strings.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Logger {

    Map<String,Integer> map;

    /** Initialize your data structure here. */
    public Logger() {

        map = new HashMap<>();

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {

        // If the message is unique directly add it in the map
        if(!map.containsKey(message)){
            map.put(message,timestamp+10);
            return true;
        }
        // If the message is not unique
        else{
            int curTime = map.get(message);

            // If the time of current message is 10 greater than older, return true
            if(timestamp >= curTime){
                map.put(message,timestamp+10);
                return true;
            }
            // If the time of current message has arrived in less than 10 seconds from the older messafe, return false
            else{
                return false;
            }
        }

    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
