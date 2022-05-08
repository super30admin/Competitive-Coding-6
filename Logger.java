import java.util.HashMap;
import java.util.Map;

public class Logger {


    Map<String, Integer> map;

    public Logger() {
        this.map = new HashMap<>();
    }

    // TC : O(1) constant lookup in the map
    // SC : O(n) n - unique input strings
    boolean shouldPrintMessage(int timestamp, String message){
        if(map.containsKey(message)) {
            if(timestamp -  map.get(message) > 10) {
                map.put(message, timestamp);
                return true;
            }
        }else {
            map.put(message, timestamp);
        }
        return false;
    }
}
