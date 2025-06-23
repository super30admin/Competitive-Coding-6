// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

public class Logger {
     HashMap<String, Integer> map = new HashMap<>();
    public boolean couldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            if(timestamp >= map.get(message) + 10){
                map.put(message, timestamp);
                return true;
            }else {
                return false;
            }
        }
        else {
            map.put(message, timestamp);
            return true;
        }
    }
}
