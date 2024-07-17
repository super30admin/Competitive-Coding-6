// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Logger {
  Map<String, Integer> hashmap;
  public Logger() {
    hashmap = new HashMap<>();
  }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(hashmap.containsKey(message)) { // present in hashmap,

            if(timestamp - hashmap.get(message) < 10) { //  check if if should be printed
                return false;
            }
        
            hashmap.put(message, timestamp); // update the value
            return true;

        }else {
            hashmap.put(message, timestamp); // print it and put in the hashmap
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */