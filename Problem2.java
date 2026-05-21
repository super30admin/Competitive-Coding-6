// https://leetcode.com/problems/beautiful-arrangement/
// Time Complexity : O(K), where k is number of valid arrangements (since we are checking the condition before the recursion and avoiding invalid calls)
// Space Complexity : O(n) due to the recursive call stack and the boolean array used to track visited elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] vis = new boolean[n+1];
        helper(n,1, vis);
        return count;
    }
    
    private void helper(int n, int pos, boolean[] vis){
        if(pos>n){
            count++;
            return;
        }
        for (int i=1; i<=n; i++){
            if((pos%i==0||i%pos==0) && !vis[i]){
                vis[i]=true;
                helper(n, pos+1, vis);
                vis[i]= false;
            }
        }
    }
}