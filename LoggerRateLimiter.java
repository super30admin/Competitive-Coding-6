//Time Complexity: O(1)
//space Complexity: O(n)

class Logger {
    HashMap<String, Integer> map;
    public Logger() {
        this.map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
       if(!map.containsKey(message)){
        map.put(message, timestamp + 10); // foo 11 // bar 12
            return true;
       }
       int var = map.get(message);
       if(timestamp < var){
            return false;
       }
       map.put(message, timestamp+10);
       return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */