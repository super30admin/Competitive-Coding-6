import java.util.*;
public class Competitivecoding {
// Time Complexity : n!
// Space Complexity : N
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//https://leetcode.com/problems/beautiful-arrangement/submissions/
    int result;
    
    public int countArrangement(int n) {
        HashSet<Integer> set = new HashSet<>();
        helper(n,1,set);
        return result;
    }
     private void helper(int n,int pointer,HashSet<Integer> set){
        if(set.size() % pointer!=0 && pointer % set.size() !=0){
            return;
        }
         if(set.size() == n){
            result++;
            return;
        }
        
        for(int i =1;i<=n;i++){
            if(!set.contains(i)){
                set.add(i);
                helper(n,i,set);
                set.remove(i);
            }    
        }
    }
    //https://leetcode.com/problems/logger-rate-limiter/
    // Time Complexity : N
    // Space Complexity : 1
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : no
    public class logger {
        HashMap<String,Integer> map;
        
        public logger()
        {
            this.map = new HashMap<String,Integer>();
        }
        
        public boolean canPrint(String message, int time){
            if(!map.containsKey(message)){
                map.put(message,time);
                return true;
            }
            int previousTime = map.get(message);
            if(time-previousTime >= 10){
                map.put(message,time);
                return true;
            }
            return false;
        }
    
}
