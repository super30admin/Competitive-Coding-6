class Logger {

   /** Initialize your data structure here. */
HashMap<String,Integer> M;
public Logger() {
    this.M=new HashMap<>(); 
}

/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity. */
public boolean shouldPrintMessage(int timestamp, String message) {
    if(M.getOrDefault(message,0)<=timestamp){
        M.put(message,timestamp+10);
        return true;
    }else return false;
}
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */