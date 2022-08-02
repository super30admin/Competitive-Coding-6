//Time Complexity: O(n); where n is the size of the queue;
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem2_2 {

	class Pair<String,Integer>{
	    
	    public String msg;
	    public int time;
	    
	    Pair(String msg, int time){
	        
	        this.msg = msg;
	        this.time = time;
	    }
	}


	class Logger {
	    
	    Queue<Pair<String,Integer>> msgQueue;
	    HashSet<String> msgSet;
	    
	    public Logger() {
	        
	        msgQueue = new LinkedList<>();
	        msgSet = new HashSet<>();
	    }
	    
	    public boolean shouldPrintMessage(int timestamp, String message) {
	        
	        while(msgQueue.size() > 0){
	            
	            Pair<String, Integer> pair = msgQueue.peek();
	            if(pair.time <= timestamp - 10){
	                
	                msgQueue.poll();
	                msgSet.remove(pair.msg);
	            }
	            else
	                break;
	        }
	        
	        if(!msgSet.contains(message))
	        {
	            msgSet.add(message);
	            Pair<String, Integer> pair = new Pair(message, timestamp);
	            msgQueue.add(pair);
	            return true;
	        }
	        
	        return false;
	    }
	}
}
