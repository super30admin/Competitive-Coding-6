// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.HashMap;
import java.util.Map;

public class MessageLog {
    Map<String, Integer> map =  new HashMap<>();	 
    public boolean printMessageLog(String message, int time){
        if(map.containsKey(message)){		
            int prev = map.get(message);	
            if(prev + 10 > time){			
                return false;				
            }else{
                map.put(message, time);		
                return true;
            }
        }
        else {								
            map.put(message, time);
            return true;
        }
    }
    
     public static void main(String[] args) {
        MessageLog log = new MessageLog();
        System.out.println(log.printMessageLog(3, "foo"));
        System.out.println(log.printMessageLog(5,"foo"));
        System.out.println(log.printMessageLog(6,"foo"));
        System.out.println(log.printMessageLog(21,"foo"));
    }
}
