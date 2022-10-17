//tc - O(1) - we are processing stream, and there will be just one string at a time 
//sc- O(n) - storing n strings at a time.  
class Logger {
    HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message))
        {   // there is no key
              map.put(message, timestamp); return true;  
        }
        
        //has message - compare timestamps
        if(map.get(message) + 10 <= timestamp)
        {
            map.put(message, timestamp);  
            return true;
        }
        //none of the conitions were passed
        return false; 
    }
}