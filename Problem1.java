// Rate limiter
//O(n) time complexity
// O(n) space complexity

class Logger {

	HashMap<String, Integer> map;

    public Logger() {

		this.map = new HashMap<>();

    }

    public boolean shouldPrintMessage(int timestamp, String message) {

		if(map.containsKey(message)  &&  map.get(message) > timeStamp) {
			return false;
		}

		map.put(message, timeStamp+10);
		return true;

    }
}
