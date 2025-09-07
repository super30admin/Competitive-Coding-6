
//Idea is to use HashMap to store message and its timestamp
//Time Complexity: O(1)
//Space Complexity: O(n)
public class DesignLogger {
    private HashMap<String, Integer> lastLoggedTimestamp;
    private int timeLimit;

    public Logger(int timeLimit) {
        this.lastLoggedTimestamp = new HashMap<>();
        this.timeLimit = timeLimit;
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!lastLoggedTimestamp.containsKey(message) || (timestamp - lastLoggedTimestamp.get(message)) >= this.timeLimit) {
            lastLoggedTimestamp.put(message, timestamp);
            return true;
        }
        return false;
    }
}
