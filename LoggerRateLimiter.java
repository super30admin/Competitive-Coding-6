// Time Complexity : O(n)
// Space Complexity : O(n)

public class Logger {
    Map<String, Integer> map = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }else{
            if(timestamp - map.get(message) >= 10){
                map.put(message, timestamp);
                return true;
            }
        }

        return false;
    }
}
