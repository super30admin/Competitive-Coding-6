/*The logger uses an unordered map to store the last timestamp each message was printed.
For each message, it checks if it has been logged before and whether the time elapsed since the last print is greater than the timeout.
If conditions are met, the timestamp is updated, and the message can be printed; otherwise, it is skipped.

Time Complexity: O(1) for both insertion and retrieval in the unordered map.

Space Complexity: O(M), where M is the number of unique messages logged.*/
#include<bits/stdc++.h>
using namespace std;
class Logger {
    unordered_map<string,int>expiry;
    int TIMEOUT=10;
public:
    Logger() {
        expiry= unordered_map<string,int>();
    }
    
    bool shouldPrintMessage(int timestamp, string message) {
        if(expiry.find(message)!=expiry.end() && expiry[message]>timestamp){
            return false;
        }
        expiry[message]=timestamp+TIMEOUT;
        return true;
    }
};

/**
 * Your Logger object will be instantiated and called as such:
 * Logger* obj = new Logger();
 * bool param_1 = obj->shouldPrintMessage(timestamp,message);
 */