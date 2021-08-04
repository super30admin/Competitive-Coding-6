// Time Complexity : O(1)
// Space Complexity : O(K) where K is no. of unique messages
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Logger {
    private HashMap<String, Integer> msgDict;
  
    /** Initialize your data structure here. */
    public Logger() {
      msgDict = new HashMap<String, Integer>();
    }
  
    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     */
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