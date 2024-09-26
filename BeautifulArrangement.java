/*
time complexity : O(2^n)
space complexity: O(n), for visited thing
*/

class Solution {
    int count;
    public int countArrangement(int n) {
        
        //base check
        if(n < 1)return 0;
        
        this.count = 0;
        
        boolean[]visited = new boolean[n+1];
        backtrack(n, 1, visited);
        
        return count;
        
    }
    
    private void backtrack(int n, int index,boolean[]visited){  //n =3, 0, visited 
        //base case
        if(index > n){  ////1,2,3
            count++; // incrementing count 
        } 
        
        
        //logic
        for(int i = 1; i <= n ; i++){
            
         
            if(!visited[i]){
                //check the beautiful conditions here
                //condition 1
                if((index % (i) == 0) || ((i) % (index) == 0)){
                    //action 
                    
                    visited[i] = true;  
                    //recurse
                    backtrack(n , index + 1, visited);
                    
                    //backtrack
                    visited[i] = false;
                    
                }
            }
            
        }
    }
}