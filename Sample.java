
import java.util.*;
class Sample {

    // Time Complexity : O(1)
    // Space Complexity : O(N) N is size of the map
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /**
     * 1. Since the message needs to be stored according to timestamp, we can directly map messages to 
     * timestamp values.
     * 2. To check if the message should be printed or not, we can simply check the difference between 
     * stored time and new time, if it is greater than or equal to 10, then message should be printed.
     * 3. Then message should be updated with the new timestamp.
     */

    /** Initialize your data structure here. */
    class Logger {
        Map<String, Integer> map;
        public Logger() {
            map = new HashMap<>();
        }
        
        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
            If this method returns false, the message will not be printed.
            The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if(map.containsKey(message)) {
                int oldTime = map.get(message);
                if(timestamp - oldTime >= 10) {
                    map.put(message, timestamp);
                    return true;
                }
                else {
                    return false;
                }
            }
            else{
                map.put(message, timestamp);
                return true;
            }
        }
    }

    // Time Complexity : O(k) k is number of valid permutations
    // Space Complexity : O(N) N is size of the recursion stack
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /**
     * 1. We can calcaulte permutation by cosidering the possible sequences.
     * 2. To make the valid arrangements, before adding to the permuation list, we can check if that number
     * is calid for that position or not. If it is valid only then add the number into the list and continue
     * adding next possible numbers in the list.
     * 3. Increase the count of valid arrangements, if the list size is equal to N.
     */


    class Solution {
    
        int count = 0;
        
        public int countArrangement(int N) {
         
            if(N == 0 || N == 1)
                return N;
            
            helper(N, new ArrayList<>());
            
            return count;
            
        }
        
        private void helper(int N, List<Integer> list) {
            
            //Base
            if(new ArrayList<>(list).size() >= N) {
                count++;
                return;
            }
            
            //Logic
            
            for(int i = 1; i <= N; i++) {
                
                if(list.contains(i))
                    continue;
                
                // action
                int size = list.size() + 1;
                if(size % i == 0 || i % size == 0) {
                    list.add(i);
                    helper(N, list);
                    list.remove(list.size()-1);
                }
                
            }
            
        }
    }
}
