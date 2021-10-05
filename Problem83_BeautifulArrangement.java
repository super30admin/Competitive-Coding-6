// Time Complexity : O(k), where k is the valid permutations
// Space Complexity : O(n), where n is the size of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    boolean[] visited;
    int count = 0;
    public int countArrangement(int n) {
        visited = new boolean[n + 1];
        backtrack(n, n);
        return count;
    }
    private void backtrack(int n, int k) {
        // base case
        if(k == 0) {
            count++;
            return;
        }
        // logic
        for(int i = 1; i <= n; i++) {
            if(!visited[i] && (k % i == 0 || i % k == 0)) {
                visited[i] = true;
                backtrack(n, k - 1);
                visited[i] = false;
            }
        }
    }
}