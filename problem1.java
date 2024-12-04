public class problem1 {
//    Time Complexity: O(n!) (backtracking explores all permutations in the worst case).
//    Space Complexity: O(n) (due to the visited array and recursion stack).
    int res;
    public int countArrangement(int n) {
        res=0;// initialize
        boolean[] visited= new boolean[n+1];
        backtrack(n,1, visited);
        return res;
    }
    private void backtrack(int n, int pos, boolean[] visited)
    {
        // Base case: if we have placed all numbers, increment result
        if (pos > n) {
            res++;
            return;
        }

        // Try placing each number from 1 to n in the current position
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true; // Mark number as visited
                backtrack(n, pos + 1, visited); // Recur for next position
                visited[i] = false; // Backtrack: unmark the number
            }
        }
    }
}
