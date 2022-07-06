// TC is O(1)
// SC is O(1)
public class LoggerRead {
    HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean flag = true;
        if(!map.containsKey(message)){
            map.put(message, timestamp+10);
            flag = true;
        }else{
            if(map.get(message) > timestamp) {
                flag = false;
            }else{
                map.put(message, timestamp+10);
            }
        }
        return flag;
    }
}