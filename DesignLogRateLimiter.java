// Approach : Utilizing HashMap to store messages and corresponding timestamp values;
// Time : O(1) + O(1) // Search for message + insert/updates message
// Space : O(n) // incoming messages stored.
class Logger {
    HashMap<String,Integer> map;
    public Logger() {
        this.map = new HashMap<>(); 
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message,timestamp);
            return true;
        }
        int oldTimestamp = map.get(message);
        if(timestamp - oldTimestamp >=10){
            map.put(message,timestamp);
            return true;
        } else{
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */