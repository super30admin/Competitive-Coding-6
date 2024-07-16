// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Logger {
  Map<String, Integer> hashmap;
  public Logger() {
    hashmap = new HashMap<>();
  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    // Check if hashmap already contains the message
    if(hashmap.containsKey(message)) {
      // If it contains, if the difference in timestamp is less than 10, return false
      if(timestamp-hashmap.get(message)<10) {
        return false;
      }
      hashmap.put(message, timestamp);
      return true;

    }else {
      hashmap.put(message, timestamp);
      return true;
    }
  }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */