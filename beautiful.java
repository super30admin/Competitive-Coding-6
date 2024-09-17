// Time Complexity : O(n!) 
// Space Complexity : O(k) ==> size of number
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    int result=0;
    public int countArrangement(int n) {
        
        boolean[] visited=new boolean[n+1];
        
        helper(visited,n,1);
        return result;
    }
    
    private void helper(boolean[] visited, int size, int index){
        
        //base case
        if(index > size){
             result++;
          //  System.out.println();
           
            
        }
           
        
        
        // logic 
        for(int i=1;i<=size;i++){
            
            if(!visited[i] && (i%index==0 || index%i==0)){
                //action
                visited[i]=true;
                
                //recurse
                helper(visited,size, index+1);
                
                // backtrack
                visited[i]=false;
                
            }
            
        }
        
        
    }
}