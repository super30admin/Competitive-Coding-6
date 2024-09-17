// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Optimized the initial HashMap based approach from O(n) to O(1)

// Your code here along with comments explaining your approach

// Remove the elements from the map which are beyond the window of 10s as they will be added even they occur in the future and not updated.

class Logger {
    
    Map<String, Integer> cache;

    /** Initialize your data structure here. */
    public Logger() {
        
        cache = new LinkedHashMap<>();
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        Iterator<Map.Entry<String, Integer>> iterator = cache.entrySet().iterator();
        
        while(iterator.hasNext()){
            
            if(timestamp - iterator.next().getValue() >= 10){
                iterator.remove();
            }
            else{
                break;
            }
        }
            
            if(cache.containsKey(message)){
                return false;
            }
        
        cache.put(message, timestamp);
        
        return true;

    }

}
