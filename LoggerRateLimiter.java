// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;

public class LoggerRateLimiter {
	class Logger {
	    private HashMap<String, Integer> messageTable;
	    
	    public Logger() {
	        this.messageTable = new HashMap<>();
	    }
	    
	    public boolean shouldPrintMessage(int timestamp, String message) {
	        if(!this.messageTable.containsKey(message)){
	            this.messageTable.put(message, timestamp);
	            return true;
	        } else {
	            int previousTimestamp = this.messageTable.get(message);
	            if ((timestamp - previousTimestamp) >= 10){
	                this.messageTable.put(message, timestamp);
	                return true;
	            } else {
	                return false;
	            }
	        }
	    }
	}
}
