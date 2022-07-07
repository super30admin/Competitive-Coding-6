/* Time Complexity :O(n!), n factorial
 * Space Complexity :O(n)
 * Did this code successfully run on Leetcode :yes
 * Any problem you faced while coding this :No
*/

class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean [] visited = new boolean[n+1];
        helper(n, 1, visited);
        return count;
    }
    private void helper(int n, int pivot, boolean [] visited){
        //base
        if(pivot > n){
            count++;
        }
        //logic
        for(int i = 1; i <= n; i++){
            if(!visited[i] && (pivot%i == 0 || i%pivot == 0)){
                //action
                visited[i] = true;
                //recuse
                helper(n, pivot+1, visited);
                //backtrack
                visited[i] = false;
            }
        }
    }
}