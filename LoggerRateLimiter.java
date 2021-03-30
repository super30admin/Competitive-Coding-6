
// Time Complexity :O(1) 
// Space Complexity :O(n) where n is the number of different messages
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//In this approach we maintain a hashmap in the global scopre. Whenever we have the input message , we put that message as the key in the hashmap and the value is the time that it came at and
//return true.
//The next time when we see the same message , we check the value of it from the hash map , if the differen s greater than or equal to 0 , we add the message to the hashmap ,update the new
//time and return true else return false.
class Logger {

    HashMap<String,Integer> map ;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
      
      if(map.containsKey(message))
      {
        
          if(Math.abs(map.get(message) - timestamp)>=10)
          {
            map.put(message,timestamp);
          }
          else
          {
            return false;
          }
        
      } 
      else
      {
        map.put(message,timestamp);
      }
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */