import java.util.HashMap;
//HashMap operations (lookup and update) are O(1).
//Space Complexity:
//The space required is O(n), where n is the number of unique messages stored in the HashMap.
public class problem2 {
    class Logger {
        private HashMap<String, Integer> messageTimestampMap;
        public Logger() {
            messageTimestampMap = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!messageTimestampMap.containsKey(message) || timestamp - messageTimestampMap.get(message) >= 10) {
                // Update the timestamp for the message
                messageTimestampMap.put(message, timestamp);
                return true;
            }
            return false;
        }
    }

}
