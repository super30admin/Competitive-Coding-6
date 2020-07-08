
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Logger {
	HashMap<String, Integer> hmap;

	/** Initialize your data structure here. */
	public Logger() {
		hmap = new HashMap<>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will not
	 * be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (!hmap.containsKey(message)) {
			hmap.put(message, timestamp);
			return true;
		} else {
			int time = hmap.get(message);
			if ((timestamp - time) >= 10) {
				hmap.put(message, timestamp);
				return true;
			}
		}
		return false;
	}
}
