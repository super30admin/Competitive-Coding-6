
// Time Complexity : o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no



// Your code here along with comments explaining your approach
/**
 * This class implements a logger system that limits the rate at which messages can be printed.
 * It ensures that a message can only be printed if at least 10 seconds have passed since it was last printed.
 */

class Logger {
    private Map<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}