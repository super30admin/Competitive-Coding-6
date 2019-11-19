
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach

class Logger {

    Map<String,Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            int prevTimeStamp = map.get(message);
            if(timestamp - prevTimeStamp>= 10){
                map.put(message,timestamp);
                return true;
            }
            return false;
        }else{
            map.put(message,timestamp);
            return true;
        }
    }
}