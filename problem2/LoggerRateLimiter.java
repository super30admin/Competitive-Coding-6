//Time Complexity : O(1)
// Space Complexity : O(n), n -> Size of incoming message
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
	Map<String, Integer> logMessages;

	/** Initialize your data structure here. */
	public LoggerRateLimiter() {
		logMessages = new HashMap<String, Integer>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will not
	 * be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (!logMessages.containsKey(message)) {
			logMessages.put(message, timestamp);
			return true;
		}

		if (timestamp - logMessages.get(message) >= 10) {
			logMessages.put(message, timestamp);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		LoggerRateLimiter obj = new LoggerRateLimiter();
		System.out.println(obj.shouldPrintMessage(1, "foo"));
		System.out.println(obj.shouldPrintMessage(2, "bar"));
		System.out.println(obj.shouldPrintMessage(3, "foo"));
		System.out.println(obj.shouldPrintMessage(8, "bar"));
		System.out.println(obj.shouldPrintMessage(10, "foo"));
		System.out.println(obj.shouldPrintMessage(11, "foo"));
	}

}
