//Time - O(n) n = number of distinct words 
//Space - O(n)
class Logger {
    unordered_map<string, int> mp;
    int time = 10;
    
    Logger() {}

    bool shouldPrintMessage(int timestamp, string message) {
        if(mp.find(message) != mp.end()){
            mp[message] = timestamp;
            return true;
        }else if(timestamp - mp[message] >= limiter){
            mp[message] = timestamp;
            return true;
        }

        return false;
    }
}