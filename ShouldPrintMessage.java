// Problem 359. Logger Rate Limiter
// Time Complexity : O(1)
// Space Complexity : O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Logger {
    private HashMap<String, Integer> msgTS;
    public Logger() {
        msgTS = new HashMap<>();
    }
    public boolean shouldPrintMessage(int ts, String msg) {
        if (!msgTS.containsKey(msg)) {
            msgTS.put(msg, ts);
            return true;
        } else {
            int lastTS = msgTS.get(msg);
            if (ts - lastTS >= 10) {
                msgTS.put(msg, ts);
                return true;
            } else {
                return false;
            }
        }
    }
}


/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */