//Time Complexity: O(1)
//Space Complexity: O(M), where M is the size of incoming messages.
class Logger {
    Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        //if the map does not contain the message, add the message and timestamp
        if(!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }
        //if the map contains the message, we will get the previous timestamp
        int previous_timestamp = map.get(message);
        //if the current timestamp of the existing message is (t + 10) times greater, then we will
        //update the timestamp and return true as we can print the message
        if(timestamp >= previous_timestamp + 10) {
            map.put(message, timestamp);
            return true;
        }
        else {
            return false;
        }
    }
}
