/***Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
It is possible that several messages arrive roughly at the same time.***/

//Time Complexity : O(1), to put message in map and check 
//Space Complexity : O(n), Number of messages
//Did this code successfully run on Leetcode : No
//Any problem you faced while coding this : No

import java.util.*;
public class Logger_Rate_Limiter {  
	public static class Logger {
		Map<String, Integer> logMap = new HashMap<>();       //Map<Message, timestamp>
		public boolean shouldPrintMessage(int timestamp, String message) {
			if(!logMap.containsKey(message)||timestamp - logMap.get(message)>=10){
				logMap.put(message,timestamp);
				return true;
			}
			else 
				return false;
		}
	}
	public static void main(String[] args) {
		Logger logger = new Logger();	

		System.out.println(logger.shouldPrintMessage(1, "foo"));

		System.out.println(logger.shouldPrintMessage(2,"bar"));       

		System.out.println(logger.shouldPrintMessage(3,"foo"));  

		System.out.println(logger.shouldPrintMessage(8,"bar"));      

		System.out.println(logger.shouldPrintMessage(10,"foo"));        

		System.out.println(logger.shouldPrintMessage(11,"foo"));        
	}
}