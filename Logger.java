// Time complexity - O(1)
// Space complexity - O(n)
// solved on leetcod e- yes
// faced any issues - No
//We use a HashMap to store each unique message and the next allowed timestamp when it can be printed again. When a new message arrives, we check if the current timestamp is greater than or equal to the stored timestamp; if so, we allow printing and update the map. This ensures that each message is printed at most once every 10 seconds with constant time checks and updates.
class Logger {
    HashMap<String, Integer> map;
    public Logger() {
        this.map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)) {
            int t = map.get(message);
            if(timestamp-t<10) return false;
            else {
                map.put(message, timestamp);
                 return true;
            }
        } else {
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
