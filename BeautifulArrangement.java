
// Time Complexity : O(n) n number of purmutation
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Backtracking
class Solution {
    
  public int countArrangement(int N) {
        return helper(new boolean[N + 1], 1);
    }
    
    private int helper(boolean[] visited, int index) {
        if (index == visited.length) 
            return 1;
        
        int res = 0;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i] && (i % index == 0 || index % i == 0) ) {
                visited[i] = true;
                res += helper(visited, index + 1);
                visited[i] = false;
            }
        }
        return res;
    }
}