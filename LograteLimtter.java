/**
Design a logger system that receives a stream of messages along with their timestamps. 
Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t
will prevent other identical messages from being printed until timestamp t + 10).

All messages will come in chronological order. Several messages may arrive at the same timestamp.

Implement the Logger class:

Logger() Initializes the logger object.
bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp, otherwise returns false.

Time Complexity : O(1)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/

class Logger 
{

    Map<String, Integer> hashMap;

    /** Initialize your data structure here. */
    public Logger() 
    {
        this.hashMap = new HashMap<>();
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) 
    {
        if( !this.hashMap.containsKey(message) )
        {
            this.hashMap.put(message, timestamp);
            return true;
        }
        else
        {
            int previousTimestamp = this.hashMap.get(message);
            
            if( timestamp - previousTimestamp >= 10)
            {
                this.hashMap.put( message, timestamp);
                return true;
            }
            
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */