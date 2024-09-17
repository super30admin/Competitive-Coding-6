// TC - O(1) 
// SC - O(n)  
class Logger {
    HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }


    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)) {
              map.put(message, timestamp); return true;  
        }

        if(map.get(message) + 10 <= timestamp) {
            map.put(message, timestamp);  
            return true;
        }
        return false; 
    }
}
