
import java.util.HashMap;

class Logger {
    /** Initialize your data structure here. */
    HashMap<String,Integer> map;
    public Logger() {
        map = new HashMap<> ();
    }
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */

    public boolean shouldPrintMessage(int timestamp, String message) {

        if(!map.containsKey (message)){
            map.put (message,timestamp);
            return true;
        }else{

            int calV = timestamp - map.get (message);

            if( calV >= 10){
                map.put (message,timestamp);

                return true;
            }
        }

        return  false;

    }

    public static void main(String[] args) {
        Logger log = new Logger ();


        System.out.println (log.shouldPrintMessage (1,"foo"));
        System.out.println (log.shouldPrintMessage (10,"foo"));
        System.out.println (log.shouldPrintMessage (12,"foo"));

        //System.out.println (log.map.entrySet ());
    }
}
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */