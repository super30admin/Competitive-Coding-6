
// Time Complexity :O(1)
// Space Complexity :O(unique message)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
 * Approach
 * Approach here si to use hashmap to keep track of all the incoming message
 * 
 * key - message
 * value - timestamp
 * 
 * whem a new message comes in check if it is in the hashmap 
 * if it is we compare the timestamp and if there difference is more than 10 we update the message and 
 * return true else return false;
 * 
 * if it is not in the hashmap put the message and timestamp in the map and return true 
 * 
 */

class Logger {

    HashMap<String, Integer> result;

    public Logger() {
        this.result = new HashMap();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (result.containsKey(message)) {
            int time = result.get(message);
            if (Math.abs(timestamp - time) >= 10) {
                result.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            result.put(message, timestamp);
        }
        return true;

    }
}
