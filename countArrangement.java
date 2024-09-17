// Time Complexity : O(N!)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    int[] vArr;
    int count;
    public int countArrangement(int N) {
        vArr = new int[N+1];
        count = 0;
        backtrack(N,1);
        return count;
        
    }
    
    public void backtrack(int n, int pos){
        
        //base case
        if(pos>n){
            count ++ ;
        }
        
        for(int i = 1; i<=n ; i++){
            //action
            if(vArr[i] == 0 && (i%pos == 0 || pos%i == 0)){
                    vArr[i] = 1;
            
            //recurse
            backtrack(n,pos+1);
            
            //backtrack
            vArr[i] = 0;
        }
    }
        
    }
}