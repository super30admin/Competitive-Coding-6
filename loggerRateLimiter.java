/*
Problem: https://leetcode.com/problems/logger-rate-limiter/
*/

// Approach 1: Using queue and set
class Log {
    String message;
    int timestamp;
    
    public Log(String m, int t) {
        message = m;
        timestamp = t;
    }
}

class Logger {

    Queue<Log> queue = null;
    HashSet<String> messages = null;
    
    public Logger() {
        messages = new HashSet<>();
        queue = new LinkedList<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && queue.peek().timestamp + 10 <= timestamp) {
            messages.remove(queue.poll().message);
        }
        if (messages.contains(message))
            return false;
        
        messages.add(message);
        queue.offer(new Log(message, timestamp));
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */


// Approach 2: Using hashmap
class Logger {

    HashMap<String, Integer> logs = null;
    public Logger() {
        logs = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!logs.containsKey(message) || timestamp >= logs.get(message)) {
            logs.put(message, timestamp + 10);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */