// Time Complexity : O(1) for each shouldPrintMessage call because HashMap operations take constant time on average
// Space Complexity : O(n) where n is the number of unique messages stored in the HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use a HashMap to store each message along with the last timestamp at which it was printed.
// If the message is new, we print it immediately and store its timestamp in the map.
// If the message already exists, we allow printing only if at least 10 seconds have passed since its previous timestamp.

class Logger {

    HashMap<String, Integer> msgDict;

    public Logger() {

        // initialize HashMap
        msgDict = new HashMap<String, Integer>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {

        // message not seen before
        if (!msgDict.containsKey(message)) {

            msgDict.put(message, timestamp);

            return true;
        }

        Integer oldTimestamp = msgDict.get(message);

        // allow message after 10 seconds
        if (timestamp - oldTimestamp >= 10) {

            msgDict.put(message, timestamp);

            return true;
        }

        // message still within restricted window
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */