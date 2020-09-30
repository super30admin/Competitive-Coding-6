    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/logger-rate-limiter/
    Time Complexity for operators : o(1) .. n is the length of the string
    Extra Space Complexity for operators : o(n) put elements into HashMap
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. Backtracking
                    A) Create hasmap with message as key and time as value
                    B) while inserting into hashmap check if it exists
                       if it exists: then check the value of timestamp and current timestamp diffrence if it is less that 10 then 
                                     return false else add again it into hashmap with new value.
                        if it does not exist then simply put it into hashmap
                    C) At the end, return true.


                    Palindrome function - just checl the first and last element and deduct right and increase left.
    */  

class Logger {

    HashMap<String,Integer> hm;
    /** Initialize your data structure here. */
    public Logger() {
        hm = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(hm.containsKey(message)){
            int k = hm.get(message);
            
            if((timestamp-k)<10){
                return false;
            }
            else
                hm.put(message,timestamp);

        }else{
            hm.put(message,timestamp);
            return true;
        }
        
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */