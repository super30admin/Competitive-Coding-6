//Time: O(1)
//Space: O(N) where N is number of incoming messages

public class Main {  
    public static class Logger {
        Map<String, Integer> logMap = new HashMap<>();       //Map<Message, timestamp>
        public boolean shouldPrintMessage(int timestamp, String message) {
            if(!logMap.containsKey(message)||timestamp - logMap.get(message)>=10){
                logMap.put(message,timestamp);
                return true;
            }
                else 
                    return false;
            }
        }
    

    public static void main(String[] args) {
        Logger logger = new Logger();	
	
        System.out.println(logger.shouldPrintMessage(1, "foo"));
	
        System.out.println(logger.shouldPrintMessage(2,"bar"));       
	
        System.out.println(logger.shouldPrintMessage(3,"foo"));  

        System.out.println(logger.shouldPrintMessage(8,"bar"));      

        System.out.println(logger.shouldPrintMessage(10,"foo"));        

        System.out.println(logger.shouldPrintMessage(11,"foo"));        
    }
}
