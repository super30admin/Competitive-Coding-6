import java.util.*;
public class Logger {
    Map<String,Integer> map=null;

    public Logger() {
       map= new HashMap<>(); 
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            int nextTimeStamp = map.get(message);
           
            if(timestamp>=nextTimeStamp){
               map.put(message,timestamp+10);  
                return true;
            } 
            else 
                return false;
        }else{
            map.put(message,timestamp+10);
            return true;
        }
        
        
    }
}
