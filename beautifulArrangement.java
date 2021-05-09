
// Time Complexity : O(K)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    int result;
    int n;
    public int countArrangement(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        this.result = 0;
        this.n = n;
        DFS(1,new boolean[n+1]);
        return result;
       
    }
    private void DFS(int index,boolean[] visited){
        
        //base
        if(index > this.n)  result++;
        
        //recurse
        for(int i = 1;i <= this.n ;i++){
            if(!visited[i] && (i % index == 0 || index % i == 0)){
                visited[i] = true;
                DFS(index+1,visited);
                visited[i] = false;
            }
        }
        
    }
}
