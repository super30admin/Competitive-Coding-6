// Time Complexity : O(1) 
// Space Complexity : O(n) for hashmap
// Did this code successfully run on Leetcode : Its LC premium
// Any problem you faced while coding this : No

//i took a hashmap with msg and timestamp as the k,v pair.
//if i dont find the msg in the map, i put it and return true to display msg
//else if i find the msg, then check if the time diff between the timestamp in map and current is >=10, if so, update the time in map and return true
//else  return false as we cannot print within 10 sec window

import java.util.HashMap;
class Logger{
    HashMap<String, Integer> hm;
    public Logger(){
    this.hm   =new HashMap<>();
    }
public boolean shouldPrintMessage(int time,String str){
if(hm.containsKey(str)){
    if( hm.get(str)-time>=10){
    hm.put(str,time);
    return true;
    }
    else{
        return false;
    }
}
else{
    hm.put(str,time);
}
return true;
}
       
public static void main(String[] args){

    Logger logger = new Logger();

logger.shouldPrintMessage(1, "foo"); //returns true; 
logger.shouldPrintMessage(2,"bar"); //returns true;
logger.shouldPrintMessage(3,"foo"); //returns false;
logger.shouldPrintMessage(8,"bar"); //returns false;
logger.shouldPrintMessage(10,"foo"); //returns false;
logger.shouldPrintMessage(11,"foo"); //returns true;
}
}