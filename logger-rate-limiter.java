
// TimeComplexity: O(1)
// SpaceComplexity: O(1)
// Explanation: I use a HashMap to store the last printed timestamp for each message. When a message arrives, I check if it exists in the map and whether at least 10 seconds have passed since it was last printed. If so, I update the timestamp and return true; otherwise, I return false. This allows constant-time checks for every log request.
class Logger {
Map<String,Integer> map = new HashMap<>();
    public Logger() {
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)) {
            if(timestamp>=map.get(message)+10) {
                map.put(message, timestamp);
                return true;
            } else{
                return false;
            }
        } else{
            map.put(message, timestamp);
            return true;
        }

        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */