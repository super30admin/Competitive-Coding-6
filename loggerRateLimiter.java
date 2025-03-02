// https://leetcode.com/problems/logger-rate-limiter/

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, a hash map is created with message as key and timestamp as value. Return true and increase timestamp by 10 when message is seen for
 * 1st time or timestamp of message is greater than timestamp of message before else return false.
 */
class Logger {
    
    HashMap<String, Integer> map;
    public Logger() {
       this.map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message) || timestamp>map.get(message)){
            map.put(message, timestamp+10);
            return true;
        }
        return false;
    }
}
