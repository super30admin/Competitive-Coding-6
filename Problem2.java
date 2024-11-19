//We can use queue as the timestamps of incoming messages are increasing.
//time o(n)
//space o(n)
class Logger {
    
    class Pair{
        String message;
        int timestamp;
        
        public Pair(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }

    /** Initialize your data structure here. */
    Queue<Pair> q;
    HashSet<String> set;
    public Logger() {
        q = new LinkedList<>();
        set = new HashSet<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while(!q.isEmpty()) {
            Pair p = q.peek();
            if(timestamp - p.timestamp >= 10) {
                q.poll();
                set.remove(p.message);
            }
            else
                break;
        }
        if(!set.contains(message)) {
            Pair p = new Pair(timestamp,message);
            q.add(p);
            set.add(message);
            return true;
        }
        else
            return false;
        
    }
}


//We can use map
//time o(1)
//space o(n)
class Logger {
    
    class Pair{
        String message;
        int timestamp;
        
        public Pair(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }

    /** Initialize your data structure here. */
    HashMap<String, Pair> map;
    public Logger() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)) {
            map.put(message, new Pair(timestamp, message));
            return true;
        }
        else {
            Pair p = map.get(message);
            if(timestamp - p.timestamp >= 10) {
                map.put(message, new Pair(timestamp, message));
                return true;
            }
            else
                return false;
        }
        
    }
}