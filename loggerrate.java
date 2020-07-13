//Time complexity:O(1)
//Space complexity:O(1)

class Logger {
    HashMap<String,Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map=new HashMap<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message))
        {
            if(timestamp-map.get(message)<10)
                return false;
        }
        map.put(message,timestamp);
        return true;
    }
}