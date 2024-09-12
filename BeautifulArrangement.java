class Solution {
    // Time Complexity : O(n!)  
// Space Complexity : O(n)  recursion stack  + visiting array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Maintain a visited array and check for non visited and satifying number
 2. Backtrack after every call to get other possible arrangements
 */    
    int result;
    public int countArrangement(int N) {
         result = 0;
        if(N == 0) return result;
        int[] visit = new int[N+1];
        backtrack(1,visit,N);
        return result;
    }
    private void backtrack(int i, int[] visit,int N){
        //base
        if(i>(N)){
            result++;
        }
        
        //logic
        for(int j=1;j<N+1;j++){
            if(visit[j]!=1){
                if(i%j==0 || j%i==0){
                    visit[j] = 1;
                    backtrack(i+1,visit, N);
                    visit[j] = 0;
                }
            }
        }
    }
}