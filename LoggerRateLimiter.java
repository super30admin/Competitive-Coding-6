// Time Complexity :  O(1)
// Space Complexity : O(N) -> No of messages
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Logger {
    private HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<String, Integer>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        if (!this.map.containsKey(message)) {
            this.map.put(message, timestamp);
            return true;
        }

        Integer oldTimestamp = this.map.get(message);
        if (timestamp - oldTimestamp >= 10) {
            this.map.put(message, timestamp);
            return true;
        } else
            return false;
    }
}