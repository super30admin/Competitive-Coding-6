class Logger {


// Time Complexity : 0(1)
// Space Complexity : 0(n) where n is the size of hashmap
// Did this code successfully run on Leetcode : No, don't have leetcode premium
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    HashMap<String, Integer> logs = null;
    public Logger() {
        logs = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!logs.containsKey(message) || timestamp >= logs.get(message)) {
            logs.put(message, timestamp + 10);
            return true;
        }
        return false;
    }
}