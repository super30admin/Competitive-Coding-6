// Time Complexity :O(n!)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach



class Solution {
    //Maintaining a visited array
    boolean[] visited;
    int count;
    public int countArrangement(int n) {
        visited = new boolean[n];
        //Calling helper recursively
        helper(0, n);
        return count;
    }

    public void helper(int pivot, int n){
        //base
        //If we are able to fill all the elements in the array, increase the count
        if(pivot == n){
            count++;
            return;
        }
        //logic
        //Try putting in all the elements in the position and recurse only for the elements which have not been used previously and which satisfy the condition for beautiful arrangement
            for(int j =0; j<n ;j++){
                if(!visited[j] && (((pivot+1)%(j+1) == 0) || ((j+1)%(pivot+1) == 0))){
                    //action
                    visited[j] = true;
                    //recurse
                    helper(pivot+1, n);
                    //backtrack
                    visited[j] = false;
                }
            }
    }
}