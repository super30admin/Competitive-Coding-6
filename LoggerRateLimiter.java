import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    //using simple HashMap DS
    //time complexity = O(1)
    //Space complexity = 0(N)
    class Logger {
        Map<String, Integer> map;

        public Logger() {
            this.map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if(map.containsKey(message) && timestamp-map.get(message)<10){
                return false;
            }
            map.put(message, timestamp);
            return true;
        }

    }
}
