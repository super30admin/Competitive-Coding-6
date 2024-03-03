// https://leetcode.com/problems/beautiful-arrangement/description/

// Time: O(N!) as there are N! permutations possible --> exponential time
// Space: O(N) recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// DFS + Backtrack
// The idea is to generate permutations that satidfy given conditions
// Using DFS to generate permutations but only go through a path if it satisfies the beautiful
// arrangement condition.


class Solution {
    private int res;
    private boolean[] visited;
    private void forLoopRecur(int idx, int n){
        if(idx==n){
            res++;
            return;
        }

        //logic
        for(int i=1;i<=n;i++){
            // if not already chosen
            if(!visited[i]){
                if(i%(idx+1)==0){
                    //action
                    visited[i]=true;
                    //recur
                    forLoopRecur(idx+1, n);
                    //backtrack
                    visited[i]=false;
                }
                else if((idx+1)%i==0){
                    //action
                    visited[i]=true;
                    //recur
                    forLoopRecur(idx+1, n);
                    //backtrack
                    visited[i]=false;
                }
            }
        } 
    }

    public int countArrangement(int n) {
        this.res=0;
        this.visited=new boolean[16];
        forLoopRecur(0,n);
        return res;
    }
}