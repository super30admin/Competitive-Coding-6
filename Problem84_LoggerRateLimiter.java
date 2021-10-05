
// Time Complexity : O(1)
// Space Complexity : O(messgaes)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.*;
class Logger {
    private HashMap<String, Integer> msgDict;
    public Logger() {
        msgDict = new HashMap<String, Integer>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!this.msgDict.containsKey(message)) {
          this.msgDict.put(message, timestamp);
          return true;
        }

        Integer oldTimestamp = this.msgDict.get(message);
        if (timestamp - oldTimestamp >= 10) {
            this.msgDict.put(message, timestamp);
            return true;
        } else
            return false;
    }
}