
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
HashMap to track timestamp of incoming message
 */

class Logger {
    HashMap<String,Integer> map;

    public Logger() {
        map=new HashMap<String,Integer>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message) && timestamp-map.get(message)<10)
            return false;

        map.put(message,timestamp);
        return true;

    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
