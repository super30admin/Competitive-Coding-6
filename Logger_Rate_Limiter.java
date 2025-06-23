/*
 * TC: O(1). for HashMap insert and lookup.
 * SC: O(n) n: unique strings in the inputs.
 * 
 * Approach: Using HashMap, i will keep track og the timestamp of the associated message.. Each time a message comes up in the inout which is laready existing then i wil check the previous time stamp of the message in my hashMap if its < 10 i will return false, else true. 
 */

class Logger {

    Map<String, Integer> messageByTimestamp;

    public Logger() {
        messageByTimestamp = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        int fTime = messageByTimestamp.getOrDefault(message, - 1);
        
        if(fTime != -1 && fTime > timestamp) {
            return false;
        }

        messageByTimestamp.put(message, timestamp + 10);

        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */