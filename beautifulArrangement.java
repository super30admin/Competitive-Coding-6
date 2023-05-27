// Time Complexity : O(n!)
// Space Complexity : O(n) for recursion stack and visited array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach
 * We use backtracking over here to find all permutations that are valid.
 * To reduce the number of recursions, we wrap the recursion in a condition
 * check which checks for the beautiful arrangement conditions and allows it
 * only if the conditions are satisfied for it's currently selected path.
 */

class Solution {
    int len, count;
    public int countArrangement(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        count = 0;
        len = n;
        int[] visited = new int[n+1]; // all unvisited (0)

        helper(1, visited);
        return count;
    }

    private void helper(int item, int[] visited) {
        // base
        if(item == len+1) {
            count++;
        }

        for(int i=1; i<=len; i++) {
            if(visited[i]==0 && (item%i == 0 || i%item == 0)) {
                // action
                visited[i] = 1; // visit the path
                // recurse
                helper(item+1, visited);
                // backtrack
                visited[i] = 0;
            }
        }
    }
}