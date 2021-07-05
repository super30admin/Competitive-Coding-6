
// Time - O(1)
// Space - O(M) incoming message that gets stored in hashtable


class Logger {

    // create hashmap
    private HashMap<String,Integer> msgDictionary;
    /** Initialize your data structure here. */
    public Logger() {

        msgDictionary = new HashMap<>();

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {

        // if message is not inside hashmap put it inside hashmap  and return true
        if(!msgDictionary.containsKey(message)) {
            msgDictionary.put(message,timestamp);
            return true;
        }

        // get the reference of old time stamp from map
        Integer oldTimeStamp = msgDictionary.get(message);

        // if difference of new and old timestamp is more then 10 put inside the map and return true else return false
        if(timestamp - oldTimeStamp >= 10) {
            msgDictionary.put(message,timestamp);
            return true;
        }

        else return false;

    }
}
