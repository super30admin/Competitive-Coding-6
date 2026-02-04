import java.util.Arrays;
import java.util.HashMap;
/*
Time Complexity:O(1)
Space Complexity: O(m) for m distinct messages stored
 */

public class Logger {
    HashMap<String,Integer> map;// map to store message and their time stamps
    public Logger() {
        this.map = new HashMap<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        // if there is a message already in the map, , we check if 10 seconds have passed since its last print.
        if(map.containsKey(message)){
            if(map.get(message)+10 <= timestamp){
                map.put(message,map.get(message));
            }
            else{
                return false;// don't show that message
            }
        }
        else {
            map.put(message,timestamp); // if the message arrives for the first time then put it in the map
        }
        return true;
    }

    public static void main(String[] args) {
        Logger logger = null;
        String[] ops = {
                "Logger",
                "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage",
                "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"
        };
        Object[][] argsList = {
                {}, {1, "foo"}, {2, "bar"}, {3, "foo"}, {8, "bar"}, {10, "foo"}, {11, "foo"}
        };

        Object[] output = new Object[ops.length];

        for(int i = 0; i < ops.length; i++){
            String op =  ops[i];
            if(op.equals("Logger")){
                logger = new Logger();
                output[i] = null;
            }
            else if(op.equals("shouldPrintMessage")){
                int timeStamp = (int)argsList[i][0];
                String message = (String)argsList[i][1];
                output[i] = logger.shouldPrintMessage(timeStamp,message);
            }
        }
        System.out.println(Arrays.toString(output));
    }
}
