// Appraoch : DFS along with recursion
// Time : Exponential(n) = n!
// Space : O(n)
class Solution {
    int count;
    public int countArrangement(int n) {
        this.count = 0;
        if (n <= 0)
            return count; 
        boolean[] visited = new boolean[n + 1];
        dfs(n, new ArrayList<>(), 1, visited);
        return count;
    }

    public void dfs(int n, List<Integer> path, int pivot, boolean[] visited) {
        // base case - pivot go out of bound
        if (pivot > n) {
            count++;
            return;
        }

        // logic
        for (int i = 1; i<=n; i++) {
            if (!visited[i] && (i % pivot == 0 || pivot % i == 0)) {
                // action
                path.add(i);
                visited[i] = true;
                // recursion
                dfs(n, path, pivot + 1, visited);
                // backtrack
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}