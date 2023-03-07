// TC: O(1) SC: O(N)
class Logger {
public:
    map<string, int> MapMessage;
    Logger() {

    }

    bool shouldPrintMessage(int timestamp, string message) {
        if(MapMessage.count(message) > 0 and MapMessage[message] + 10 > timestamp){
            return false;
        }
        MapMessage[message] = timestamp;
        return true;
    }
};
