/* Time Complexity : O(n) where n is the input list 
   Space Complexity :   O(n)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Logger {
    /** Initialize your data structure here. */
    int t;
    HashMap<String,Integer> hm;
    public Logger() {
        this.t=0;
        hm = new HashMap<>();
    }
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(hm.containsKey(message)){
            int retrievedTime = hm.get(message);
            if(timestamp < retrievedTime){
                return false;
            }
            else{
                int newtime = timestamp + 10;
                hm.put(message,newtime);
                return true;
            }
        }
        else
        {
            int newtime = timestamp + 10;
            hm.put(message,newtime);
            return true;
        }
    }
}
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */