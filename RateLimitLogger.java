// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
/*Approach
1) We use a Map. and we store the message as key and value as integer for timestamp
2) if we have the message already with us, we calculate the timestamp -map.get(message)>=10
then we put again in the map and return true
3) if map does not contain the message and put the message in string and integer value in map as value

*/

import java.util.*;
class RateLimitLogger {

    Map<String,Integer> map;
    /** Initialize your data structure here. */
    public RateLimitLogger() {
        
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(!map.containsKey(message))
        {
            map.put(message,timestamp);
            return true;
            
        }
        else if(map.containsKey(message))
        {
            
            if(timestamp-map.get(message)>=10)
            {
                map.put(message,timestamp);
                return true;
            }
            
        }
        
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */