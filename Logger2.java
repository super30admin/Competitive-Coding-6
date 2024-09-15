
/**
 * Hashmap solution doesn't work for large dataset.Although solution developed
 * using Hashmap has better time complexity space complexity O(N) it is bound to fail for larger dataset
 *  So Use of Set and PriorityQueue will solve the problem for larger dataset
 *  Set will store unique messages and Priority Queue will
 * store recent 10 messages to avoid process large chunk of data
 * So we need to check messages for last 10 timestamp.Indeed,this is fater then HashMap
 *  
 * 
 */  
class Log {
    int timestamp;
    String message;
    public Log(int aTimestamp, String aMessage) {
        timestamp = aTimestamp;
        message = aMessage;
    }
}

public class Logger {
    PriorityQueue<Log> recentLogs;
    Set<String> recentMessages;   
    
    /** Initialize your data structure here. */
    public Logger() {
        recentLogs = new PriorityQueue<Log>(10, new Comparator<Log>() {
            public int compare(Log l1, Log l2) {
                return l1.timestamp - l2.timestamp;
            }
        });
        
        recentMessages = new HashSet<String>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (recentLogs.size() > 0)   {
            Log log = recentLogs.peek();
            // discard the logs older than 10 minutes
            if (timestamp - log.timestamp >= 10) {
                recentLogs.poll();
                recentMessages.remove(log.message);
            } else 
            	break;
        }
        boolean res = !recentMessages.contains(message);
        if (res) {
            recentLogs.add(new Log(timestamp, message));
            recentMessages.add(message);
        }
        return res;
    }
}