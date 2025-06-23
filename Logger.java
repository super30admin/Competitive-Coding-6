// Time Complexity : O(1)
// Space Complexity : O(n)
/*Approach : The approach uses a HashMap to track the last time each message was printed. When a new message arrives, 
it checks if the message was printed in the last 10 seconds. If it was, the message isn't printed again; if it wasn't, 
the message is printed and the timestamp is updated in the HashMap. This ensures that the same message isn't printed 
too frequently. 
*/
public class Logger {
    // HashMap to store the last printed timestamp for each message
    HashMap<String, Integer> map;

    // Constructor to initialize the HashMap
    public Logger() {
        this.map = new HashMap<>();
    }

    // Method to check if a message can be printed at the given timestamp
    public boolean couldPrintMessage(int timestamp, String message) {
        // If the message exists in the map and the last printed timestamp + 10 is greater than the current timestamp, return false
        if (map.containsKey(message) && map.get(message) + 10 > timestamp) {
            return false;
        }
        // Update the map with the current timestamp for the message
        map.put(message, timestamp);
        return true;
    }
}
