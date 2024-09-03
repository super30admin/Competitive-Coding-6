// Problem 526. Beautiful Arrangement
// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class CountArrangement {
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        return count(n, 1, visited);
    }
    private int count(int n, int pos, boolean[] visited) {
        if (pos > n) {
            return 1;
        }
        int totalCount = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                totalCount += count(n, pos + 1, visited);
                visited[i] = false;
            }
        }
        return totalCount;
    }
}
