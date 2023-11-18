import java.util.HashMap;
import java.util.Map;

class Logger {
	Map<String, Integer> map;

	public Logger() {
		map = new HashMap<>();
	}

	/**
	 * Put every message with its timestamp in map. When same message with different
	 * timestamp arrives check if the difference is 10. If not, return false, else
	 * true.
	 * 
	 * TC: O(1) SC: O(N)
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (!map.containsKey(message)) {
			map.put(message, timestamp);
			return true;
		}

		int oldTimeStamp = map.get(message);
		if (timestamp - oldTimeStamp >= 10) {
			map.put(message, timestamp);
			return true;
		} else
			return false;
	}
}

/**
 * Your Logger object will be instantiated and called as such: Logger obj = new
 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */