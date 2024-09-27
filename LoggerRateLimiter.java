//Approach - HashMap - Key - Message, value - timestamp
//Time Complexity - O(1) - constant lookup with the message
//Space Complexity - O(N) - number of incoming messages
class Logger {

  HashMap<String, Integer> logTimeDict;

  /** Initialize your data structure here. */
  public Logger() {
    logTimeDict = new HashMap<>();
  }

  /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
   If this method returns false, the message will not be printed.
   The timestamp is in seconds granularity. */
  public boolean shouldPrintMessage(int timestamp, String message) {
    if(logTimeDict.containsKey(message)){
      if(logTimeDict.get(message)+10 > timestamp){
        return false;
      }
    }
    logTimeDict.put(message, timestamp);
    return true;
  }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */