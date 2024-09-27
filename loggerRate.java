// TC: O(1)
// SC: O(N) store values in hashMap


import java.util.*;

public class loggerRate {

	HashMap<String, Integer> map = new HashMap<>();
;
	public boolean shouldPrintMessage(int time, String message) {
		
		if(!map.containsKey(message) || (time - map.get(message) >= 10) ) {
			map.put(message, time);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		loggerRate logger = new loggerRate();
		System.out.println(logger.shouldPrintMessage(1, "foo")); //returns true; 

		// logging string "bar" at timestamp 2
		System.out.println(logger.shouldPrintMessage(2,"bar"));// returns true;

		// logging string "foo" at timestamp 3
		System.out.println(logger.shouldPrintMessage(3,"foo")); //returns false;

		// logging string "bar" at timestamp 8
		System.out.println(logger.shouldPrintMessage(8,"bar")); //returns false;

		// logging string "foo" at timestamp 10
		System.out.println(logger.shouldPrintMessage(10,"foo"));// returns false;

		// logging string "foo" at timestamp 11
		System.out.println(logger.shouldPrintMessage(11,"foo")); //returns true;
	}
}
