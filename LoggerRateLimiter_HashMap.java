import java.util.HashMap;

public class LoggerRateLimiter_HashMap {

        //DESIGN - HASH MAP - O(1)

        private static HashMap<String, Integer> mapMsgTime;

        public LoggerRateLimiter_HashMap() {

            mapMsgTime = new HashMap<>();

        }

        public boolean shouldPrintMessage(int timestamp, String message) { //O(1)

            if(!mapMsgTime.containsKey(message) || mapMsgTime.get(message) + 10 <= timestamp) {

                mapMsgTime.put(message, timestamp); // O(M)
                return true;

            } else {

                return false;
            }

        }

}

/*
TIME COMPLEXITY = O(1)
Hash map search takes in constant time

SPACE COMPLEXITY = O(M)
all messages go into map, in worst case
*/

/*
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */


