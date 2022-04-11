import java.util.HashMap;

//Time Complexity : O(1)
//Space Complexity : O(n); where n is total number of incoming messages
public class Logger {	
	HashMap<String, Integer> map; 
    public Logger() {
        map= new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        //If new message
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }
        
        //If message exists, check the timestamp diff
        if(timestamp- map.get(message) >=10){
            this.map.put(message, timestamp);
            return true;
        }else{
            return false;
        }
    } 
	
	// Driver code to test above 
	public static void main (String[] args) {
		Logger logger = new Logger();
		System.out.println(logger.shouldPrintMessage(1, "foo"));  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
		System.out.println(logger.shouldPrintMessage(2, "bar"));  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
		System.out.println(logger.shouldPrintMessage(3, "foo"));  // 3 < 11, return false
		System.out.println(logger.shouldPrintMessage(8, "bar"));  // 8 < 12, return false
		System.out.println(logger.shouldPrintMessage(10, "foo")); // 10 < 11, return false
		System.out.println(logger.shouldPrintMessage(11, "foo")); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
	}
}
