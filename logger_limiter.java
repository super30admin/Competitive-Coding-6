

//TimeComplexity: O(1)
//SpaceComplexity: O(1)
import java.util.*;
class Logger {
  HashMap<String, Integer> map = new HashMap<>();
    public Logger() {
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)) {
            if((map.get(message) + 10) > timestamp) {
                return false;
            } else {
                map.put(message, timestamp);
                return true;
            }
        }
        map.put(message, timestamp);
        return true;
    }
    public static void main(String[] args) {
        Logger log = new Logger();
        boolean flag;
        flag = log.shouldPrintMessage(1,"foo");
        System.out.println(flag);
       flag = log.shouldPrintMessage(2,"bar");
       System.out.println(flag);
       flag = log.shouldPrintMessage(3,"foo");
       System.out.println(flag);
       flag = log.shouldPrintMessage(8,"bar");
       System.out.println(flag);
       flag = log.shouldPrintMessage(10,"foo");
       System.out.println(flag);
       flag = log.shouldPrintMessage(11,"foo");
       System.out.println(flag);
}
}