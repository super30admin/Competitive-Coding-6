/*
 * #359. Logger Rate Limiter
 * 
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.

Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.

It is possible that several messages arrive roughly at the same time.

Example:

Logger logger = new Logger();

// logging string "foo" at timestamp 1
logger.shouldPrintMessage(1, "foo"); returns true; 

// logging string "bar" at timestamp 2
logger.shouldPrintMessage(2,"bar"); returns true;

// logging string "foo" at timestamp 3
logger.shouldPrintMessage(3,"foo"); returns false;

// logging string "bar" at timestamp 8
logger.shouldPrintMessage(8,"bar"); returns false;

// logging string "foo" at timestamp 10
logger.shouldPrintMessage(10,"foo"); returns false;

// logging string "foo" at timestamp 11
logger.shouldPrintMessage(11,"foo"); returns true;

 */


/*
 * Time Complexity: O (1) -> Lookup and update operations of a HashMap takes constant time
 * 
 * Space Complexity: O (N) -> 'N' is the size of all messages. Over the time, HashMap will have entry for each unique message that has appeared
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */


package com.s30.edu.competitivecoding6;

import java.util.HashMap;

public class LoggerRateLimiter {
	// Declare a HashMap to store message and timestamp as key value pairs
	HashMap<String, Integer> map;

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
    	// Initialize the HashMap data structure here
        map = new HashMap<String, Integer>(); 
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
    	// Check if message has appeared previously by lookup in HashMap
    	// If not, then add message and timestamp as a key value pair in a HashMap and return true, meaning unique message and can be printed
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }
        // If message appears again with different timestamp, meaning already present in a HashMap
        // Get the previous timestamp of that message
        int previousTimeStamp = map.get(message);
        
        // Check if the message was printed in the same time frame of 10 seconds window
        // If not, then update the timestamp of that message(value) in HashMap and return true, meaning same message can be printed again in another 10 seconds window
        if(timestamp - previousTimeStamp >= 10){
            map.put(message, timestamp);
            return true;
        }
        // If yes, then we cannot print that message again in the same 10 seconds window, return false 
        else{
            return false;
        }
    }
    
}
