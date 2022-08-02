//Time Complexity: O(1)
//Space Complexity: O(m); where m is the no. of messages passed.
//Code run successfully on LeetCode.

public class Problem2_1 {


    HashMap<String, Integer> map;
    public Logger() {
        
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(!map.containsKey(message)){
            
             map.put(message, timestamp);
             return true;
        }
           
        int time = map.get(message) + 10;
        
        if(timestamp >= time){
            map.put(message, timestamp);
            return true;
        }
        
        return false;
    }
}
