// Time Complexity: O(1)
// Space Complexity: O(no. of messages)
public class Logger{
        HashMap<String, Integer> times;
public Logger(){
    times = new HashMap<>();
}
        public boolean shouldPrintMessage(int timestamp, String message){
            if(times.containsKey(message)){
                if(timestamp - times.get(message)>=10){
                    times.put(message,timestamp);
                    return true;
                }
                return false;
             } else {
                times.put(message, timestamp);
                return true;
            }
        }
    }
