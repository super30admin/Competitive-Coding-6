// Time Complexity: O(1)
// Space Complexity: O(n) where n is the number of messages
// Did this code successfully run on Leetcode : Yes

//Approach: 
// 1. We will use a hashmap to store the message and the timestamp when it was last printed.
// 2. If the message is not present in the hashmap, we will add it to the hashmap and return true.
// 3. If the message is present in the hashmap, we will check if the timestamp is greater than the last printed timestamp + 10.
// 4. If it is greater, we will update the timestamp in the hashmap and return true.

class Logger {
    unordered_map<string, int> map;
    public:
        Logger() {
            
        }
        
        bool shouldPrintMessage(int timestamp, string message) { 
            if(map.find(message) != map.end()){
                if(map[message] + 10 <= timestamp){
                    map[message] = timestamp;
                    return true;
                }
                
            }else{
                map[message] = timestamp;
                return true;}
            
            return false;;
        }
    };