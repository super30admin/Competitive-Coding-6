// https://leetcode.com/problems/logger-rate-limiter/description/

/**
 * Time Complexity: O(1) since we use map for searching
 * Space Complexity: O(n) for storing messages
 */

/**
 * Approach: We check if the message is present in map or not.
 * If absent, we store the message and return true
 * else we check if current time is less than 10 secs, if yes return true
 * else false
 */

class Logger {
    Map<String, Integer> map;

    Logger(){
        this.map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message){

        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }

        if((timestamp - map.get(message)) <= 10){
            return false;
        }

        map.put(message, timestamp);
        return true;
    }
}