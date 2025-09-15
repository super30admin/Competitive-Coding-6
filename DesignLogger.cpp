#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We store the last printed time for each message in a HashMap.
When a message comes in, we check if 10 seconds have passed since its last print.
If enough time has passed, we update the time and allow printing; otherwise, we block it.
TC : O(1), SC : O(m) for m distinct message stored
*/
class Logger{
    unordered_map<string, int> map;
public:
    Logger() {}

    bool shouldPrintMessage(int timeStamp, const string& message){
        int prevTimeStamp;
        if(map.find(message) == map.end()){
            prevTimeStamp = map[message];
            if(timeStamp < prevTimeStamp + 10) return false;
        }
        map[message] = timeStamp;
        return true;
    }
};
