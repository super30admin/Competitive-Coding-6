import java.util.HashMap;
//Time Complexity:O(1)
//Space Complexity: O(1)
class Logger {
    HashMap<String,Integer> map;
        public Logger() {
            map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        int timeElaspsed;

        if(map.containsKey(message)){
            timeElaspsed = timestamp - map.get(message);
            if(timeElaspsed>=10){
                map.put(message, timestamp);
                return true;
            }
            return false;
        }
        else{
             map.put(message, timestamp);
                return true;
        }

    }
    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));  // true
        System.out.println(logger.shouldPrintMessage(2, "bar"));  // true
        System.out.println(logger.shouldPrintMessage(3, "foo"));  // false
        System.out.println(logger.shouldPrintMessage(8, "bar"));  // false
        System.out.println(logger.shouldPrintMessage(10, "foo")); // false
        System.out.println(logger.shouldPrintMessage(11, "foo")); // true
    }

}