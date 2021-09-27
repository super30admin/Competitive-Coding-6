// Time Complexity : n! where n is the input number
// Space Complexity : O(n) n is the input number
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int count;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        helper(visited, n, 1);
        return count;
    }
    
    public void helper(boolean[] visited, int n, int index){
        // base
        if(index == n+1) {
            count++;
            return;
        }
        //logic
        for(int i=1; i<=n; i++){
            if(!visited[i] && isCorrectPosition(i, index)){
                visited[i] = true;
                helper(visited, n, index+1);
                visited[i] = false;
            }
            else continue;
        }
    }
    
    private boolean isCorrectPosition(int i, int index){
        if((i % index == 0) || (index % i == 0)) {
            return true;
        }
        else {
            return false;
        }
    }
}