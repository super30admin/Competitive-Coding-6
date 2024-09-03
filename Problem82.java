
// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    private int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        helper(n, 1, visited);
        return count;
    }
    private void helper(int n, int pos, boolean[] visited){
        //base condition
        if(pos>n){
            count++;
        }
        //logic
        for(int i = 1; i<=n; i++){
            if(!visited[i]){
                if(pos%i==0 || i%pos ==0){
                    visited[i]=true;
                    helper(n,pos+1,visited);
                    visited[i]=false;
                }
            }
        }
    }
}
