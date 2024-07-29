// TC - O(n!)
// SC = O(n)
class Solution {
    int count = 0; 

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1]; 
        backtrack(1, n, visited); 
        return count;
    }

    private void backtrack(int pivot, int n, boolean[] visited) {
        if (pivot > n) { 
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (pivot % i == 0 || i % pivot == 0)) { 
                visited[i] = true;
                backtrack(pivot + 1, n, visited);
                visited[i] = false;
            }
        }
    }
}
