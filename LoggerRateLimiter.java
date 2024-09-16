import java.util.*;
//Time Complexity: o(L) ~ o(1)
//Space Complexity - o(L) ~ o(1) length of the string/message
public class LoggerRateLimiter {
	

	    HashMap<String,Integer> map;
	    /** Initialize your data structure here. */
	    public LoggerRateLimiter() {
	        map = new HashMap<>();
	        
	    }
	    
	    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	        If this method returns false, the message will not be printed.
	        The timestamp is in seconds granularity. */
	    public boolean shouldPrintMessage(int timestamp, String message) {
	        //if message is there check for seconds
	        if(map.containsKey(message)) {
	            //deduct new sec from older timestamp
	            int sec = timestamp - map.get(message);
	            //if it is 10 or longer update timestamp and return
	            if(sec>=10){
	                map.put(message,timestamp);
	                return true;
	            } else {
	                //else return false
	                return false;
	            }
	        } else {
	            //return true and add message to hashmap
	            map.put(message,timestamp);
	        }
	        return true;
	    }
}

	/**
	 * Your Logger object will be instantiated and called as such:
	 * Logger obj = new Logger();
	 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
	 */
