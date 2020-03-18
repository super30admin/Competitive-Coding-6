
// Your code here along with comments explaining your approach
//Time Complexity - O(1) and Space O(N) - where N is the size of unique messages
public class Logger {
    HashMap<String,Integer> msgTimestamp;
    /** Initialize your data structure here. */
    public Logger() {
        msgTimestamp=new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false. The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
       
            if(!msgTimestamp.containsKey(message)||timestamp - msgTimestamp.get(message)>=10){
                msgTimestamp.put(message,timestamp);
                return true;
            }
            return false;
        }
     }