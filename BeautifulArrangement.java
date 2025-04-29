
// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class BeautifulArrangement {
    int output;
    public int countArrangement(int n) {
        backtrack(new boolean[n+1], 1, n);
        return output;

    }

    private void backtrack(boolean[] visited, int curr, int n) {
        if (curr > n) {
            output++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i%curr == 0 || curr%i == 0)) {
                visited[i] = true;
                backtrack(visited, curr + 1, n);
                visited[i] = false;
            }
        }
    }
}