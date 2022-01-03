import java.util.*;

public class LoggerRateLimiter {
        /*

        TC:O(1)
        SC:O(n) where n is the number of messages

        */
        HashMap<String,Integer> map;
        public LoggerRateLimiter() {
            map=new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if(map.containsKey(message)){
                int t=map.get(message);
                if(t<=timestamp){
                    map.put(message,timestamp+10);
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                map.put(message,timestamp+10);
                return true;
            }
        }

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
}
