// Time Complexity : O(1)
// Space Complexity : 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : No




import java.util.HashMap; 
public class Main
{
    HashMap<String,Integer> map=new HashMap();
	public static void main(String[] args) {
		
		Main main = new Main();
		System.out.println(main.isMessageDisplayedInLast10Sec(1,"Hello"));
		System.out.println(main.isMessageDisplayedInLast10Sec(2,"Hello"));
		
	}
	
    	public boolean isMessageDisplayedInLast10Sec(int timestamp, String message){
    	    
    	    if(!map.containsKey(message) || (timestamp-map.get(message))>=10){
    	        map.put(message,timestamp);
    	        return true;
    	    }
    	    return false;
    	    
    	}
}
