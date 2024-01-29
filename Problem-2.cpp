// Time Complexity : O(1)

// Space Complexity : O(N) - Map

// Did this code successfully run on Leetcode : YES

// Appoarch: Using a hashmap to store the message and timestamp and computing it accordingly to
// return true or false.

// 359. Logger Rate Limiter

#include <bits/stdc++.h>
using namespace std;

class Logger {
public:
    map<string,int> mp;
    Logger() {
    }
    
    bool shouldPrintMessage(int timestamp, string message) {
        bool flag;
        if(mp.find(message) != mp.end()){
            if(mp[message] + 10 > timestamp){
                return false;
            }
        } 
         mp[message] = timestamp;
         return true; 
    }
};