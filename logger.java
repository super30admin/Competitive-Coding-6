// Time - O(1)
// Space - O(N)

class Logger {
  private HashMap<String, Integer> map;
  int timeDiff;
  /** Initialize your data structure here. */
  public Logger() {
    map = new HashMap<String, Integer>();
    timeDiff = 10;
  }

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {

    if (!this.map.containsKey(message)) {
      this.map.put(message, timestamp);
      return true;
    }

    int timeOld = this.map.get(message);
    if (timestamp - timeOld < 10) {
      return false;
    }
      
     this.map.put(message, timestamp);
     return true;
  }
}
