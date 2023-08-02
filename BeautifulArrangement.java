// Time Complexity : Exponential O(n!)
// Space Complexity : O(n) - n used for visited array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    /* keep count of valid perm */
    int count = 0;

    public int countArrangement(int N) {
        /* edge case */
        if (N <= 0)
            return 0;
        /* keep array of visited so we dont revisit it */
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count; /* return */
    }

    public void calculate(int N, int pos, boolean[] visited) {
        /* if pos > n increase count */
        if (pos > N)
            count++;
        /* try to place it add the valid position */
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true; // action
                calculate(N, pos + 1, visited); // recusrion
                visited[i] = false; // backtrack
            }
        }
    }
}