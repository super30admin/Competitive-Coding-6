    //TC: O(n)
    //SC: O(n)
import java.util.HashMap;

public class LoggerRateLimiter {

    HashMap<String, Integer> hm;
    public LoggerRateLimiter(){
        this.hm = new HashMap<>();
    }
    public boolean shouldPrintMessage(int timeStamp, String message) {
        if (!hm.containsKey(message)) {
            hm.put(message, timeStamp + 10);
            return true;
        }
        if (hm.get(message) <= timeStamp) {
            hm.put(message, timeStamp + 10);
            return true;
        }
        return false;
    }
}