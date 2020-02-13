// 359. Logger Rate Limiter
// S30 Big N Problem #82 {Hard}
// Space wise efficient as only last 10 seconds logs are stored
class Logger {

    private class vNode{
        int tstamp;
        String msg;
        vNode(String msg, Integer tstamp){
            this.msg=msg;
            this.tstamp=tstamp;
        }
    }
    
    Queue<vNode> recentQ;
    Set<String> recentM;
    
    /** Initialize your data structure here. */
    public Logger() {
        recentQ=new LinkedList<>();
        recentM=new HashSet<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
    
        //loop through the entire recent Queue to remove all messages older than 10 secs
        while(!recentQ.isEmpty()){
            vNode oldNode=recentQ.peek();
            if(Math.abs(oldNode.tstamp-timestamp)>=10){
                recentQ.poll();
                recentM.remove(oldNode.msg);
            }
            else break;
        }
        
        if(recentM.contains(message)) return false;
        recentM.add(message);
        recentQ.add(new vNode(message,timestamp));
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */