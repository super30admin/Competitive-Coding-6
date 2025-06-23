// Time Complexity : O(1)
// Space Complexity : O(n)
// My Approach - The approach is to make a hashmap to store all the different messages and the time at which they arrive
// and keep a track of the through searching in map and checking if the message can be printed or not
import java.util.*;
public class LoggerSystem {
     static class Logger {
         HashMap<String, Integer> map;
        Logger() {
            this.map  = new HashMap<>();
        }
         boolean shouldPrintMessage(int timeStamp, String message) {
            if(map.containsKey(message)) {
                if(timeStamp >= map.get(message) + 10) {
                    map.put(message, timeStamp);
                    return true;
                }
                return false;
            }
            map.put(message, timeStamp);
            return true;
         }
    }
    public static void main(String[] args) {
        Logger logs = new Logger();
        System.out.println("Should Print Message? " + logs.shouldPrintMessage(1, "foo"));
        System.out.println("Should Print Message? " + logs.shouldPrintMessage(2, "bar"));
        System.out.println("Should Print Message? " + logs.shouldPrintMessage(3, "foo"));
        System.out.println("Should Print Message? " + logs.shouldPrintMessage(8, "bar"));
        System.out.println("Should Print Message? " + logs.shouldPrintMessage(10, "foo"));
        System.out.println("Should Print Message? " + logs.shouldPrintMessage(11, "foo"));

    }

}
