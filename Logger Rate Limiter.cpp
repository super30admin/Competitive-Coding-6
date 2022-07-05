//Time Complexity- O(1) //number of permutations
//Space Complexity- O(messages)

class Logger {
public:
    unordered_map<string,int> mp;
    Logger() {
        
    }
    
    bool shouldPrintMessage(int timestamp, string message) {
        
        if(mp[message]<=timestamp){
            mp[message]=timestamp+10;
            return true;
        }
        return false;
    }
};

/**
 * Your Logger object will be instantiated and called as such:
 * Logger* obj = new Logger();
 * bool param_1 = obj->shouldPrintMessage(timestamp,message);
 */