// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No

import java.util.HashMap;
import java.util.Map;

public class Logger {
    Map<String, Integer> map =  new HashMap<>();	// hashmap to store message as the key and time 
    public boolean shouldPrintMessage(int time, String message){
        if(map.containsKey(message)){		// if the message was already printed
            int prev = map.get(message);	// get the time at which it was printed
            if(prev + 10 > time){			// add 10 and compare if it was printed in the last 10 seconds
                return false;				// if it was printed, return false
            }else{
                map.put(message, time);		// else, update the new value and return true
                return true;
            }
        }
        else {								// if it was the first time, add to the map and return true;
            map.put(message, time);
            return true;
        }
    }
}
