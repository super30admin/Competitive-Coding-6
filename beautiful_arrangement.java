// Time Complexity : O(n!) because we try multiple unused numbers for every position similar to permutations
// Space Complexity : O(n) for the visited array and recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use backtracking to fill positions from 1 to n by trying every unused number that satisfies the divisibility condition.
// For each position, a number can be placed only if pos % num == 0 or num % pos == 0.
// Whenever all positions are filled successfully, we increment the count as one valid beautiful arrangement.

class Solution {

    int count;

    public int countArrangement(int n) {

        count = 0;

        boolean[] visited = new boolean[n + 1];

        helper(visited, n, 1);

        return count;
    }

    private void helper(boolean[] visited, int n, int pos) {

        // all positions filled
        if (pos > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {

            // choose valid unused number
            if (!visited[i] &&
                (pos % i == 0 || i % pos == 0)) {

                // mark visited
                visited[i] = true;

                // recurse for next position
                helper(visited, n, pos + 1);

                // backtrack
                visited[i] = false;
            }
        }
    }
}
