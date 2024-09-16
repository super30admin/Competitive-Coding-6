//Time complexity: O(1)
//Space complexity: O(n)// n is number of messages

class Logger {
  private HashMap<String, Integer> map;
  public Logger() {
    map = new HashMap<String, Integer>();
  }

 
  public boolean shouldPrintMessage(int timestamp, String message) {

    if (!map.containsKey(message)) {
     map.put(message, timestamp);
      return true;
    }

    Integer oldtimestamp = map.get(message);
    if (timestamp - oldtimestamp >= 10) {
      map.put(message, timestamp);
      return true;
    } else
      return false;
  }
}