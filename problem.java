class Logger{
    HashMap<String, Integer> map;
    Logger(){    
        map = new HashMap<>();
    }
    
    public boolean printMessage(int time, String message){
        if(message == null || message.length() == 0) return false;
        boolean result = false;
        
        if(map.containsKey(message)){
            int t = map.get(message);
            if(time - t < 10){
                return false;
            }
            else{
                result = true;
                map.put(message, time);
            }
        }
        else{
            map.put(message, time);
            result = true;
        }
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Logger logger = new Logger();
        System.out.println(logger.printMessage(1, "foo"));
        System.out.println(logger.printMessage(2, "bar"));
        System.out.println(logger.printMessage(3, "foo"));
        System.out.println(logger.printMessage(11, "foo"));
        
    }
}

//time complexity O(1)
//space complexity O(n)