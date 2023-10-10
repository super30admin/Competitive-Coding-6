// Time Complexity : O(1) check if the key exists in map takes constant time
// Space Complexity : O(n) where n is the number of unique strings
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    HashMap<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            int prevStamp = map.get(message);
            if(timestamp - prevStamp >= 10){
                map.put(message, timestamp);
                return true;
            }else{
                return false;
            }
        }
        map.put(message, timestamp);

        return true;
    }
}
