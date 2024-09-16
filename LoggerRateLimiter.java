// Time Complexity : O(1)
// Space Complexity : O(M) where M is the number of different types of messages
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a HashMap that will store message and timestamp and whenever the shouldPrintMessage is called
// We will check if it is there in the hashmap or not, if its not there we will add it with current timestamp and return true
// If its there we will take get the timestamp at which it was added to hashmap
//If the current timestamp minus the obtained is greater than equal to 10, we will update the timestamp and return true
// Otherwise we will return false

class Logger {
    HashMap<String, Integer> hm;
    public Logger() {
            hm = new HashMap();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(hm.containsKey(message)){
            int x = hm.get(message);
            if(timestamp - x >= 10){
                hm.put(message, timestamp);
                return true;
            }
            else
                return false;
            
        }
        else{
            hm.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */