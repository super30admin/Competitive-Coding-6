// https://leetcode.com/problems/logger-rate-limiter/

// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, create a boolean array of size n+1 and use helper function with n and start from index 1 with boolean array. When index crosses n
 * add 1 to count. For every recursive call check with index + 1. Finally return count.
 */
class Solution {
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        return helper(n, 1, visited);
    }

    private int helper(int n, int index, boolean[] visited) {
        if (index > n) {
            return 1;
        }
        
        int count = 0;
        for (int num = 1; num <= n; num++) {
            if (!visited[num] && (num % index == 0 || index % num == 0)) {
                visited[num] = true;
                count += helper(n, index + 1, visited);
                visited[num] = false;
            }
        }
        return count;
    }
}
