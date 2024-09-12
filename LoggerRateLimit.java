/*

// Time Complexity : O(1) chk and return true/false if message in mp.
                     O(1) put msg in mp and return true.
// Space Complexity :O(n) number of messages.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//nope

// Your code here along with comments explaining your approach

*/
class Logger {
    HashMap<String, Integer> mp;

    public Logger() {
        mp = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int time = mp.getOrDefault(message, -1);
        //get last time of msg. if new last time is -1.
        //new add to mp. return true
        if(time < 0){
            mp.put(message, timestamp);
            return true;
        }
        //not new see if should be printed
        else if(timestamp  - time >= 10){
            mp.put(message, timestamp);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
