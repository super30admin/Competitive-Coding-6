//Problem 84 :  Logger Rate Limiter
//TC: O(1)
//SC: O(Total Distinct Input Messages)

/*Comments

//if insertion order of printed message log is required which means last printed message should always be on top then use hashmap with doubly linkedlist or LinkedHashMap just as LRU cache and remove/evict the node from tail if map size increases a threshold otherwise simply use hashmap to store message as key and timestamp as value and no need to delete anything
    
//Note: Ask interviewer about is it required to save last log in top of the map or order doesn't matter and we dont have to delete/evict logs just like LRU cache. If he says order matters and last printed message should always be on top and evict the least recent one then go with HashMap and Doubly Linkedlist or LinkedHashMap just like LRU, otherwise go with simple hashmap i.e key as message and value as timestamp
  

*/

import java.util.*;
class LoggerHashMap {
  
    private Map<String,Integer> map;
    
    /** Initialize your data structure here. */
    public LoggerHashMap() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(!map.containsKey(message)){
            map.put(message,timestamp+10);
            return true;
        }
        
        if(timestamp>=map.get(message)){
            map.put(message,timestamp+10);
            return true;
        }
        
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */