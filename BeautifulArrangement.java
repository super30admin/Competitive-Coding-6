//Idea is to use exhaustive approach to form all permutations and check if they are valid using a visited array

//Time Complexity: O(2^n)
//Space Complexity: O(n)
public class BeautifulArrangement {
    private int count = 0;
    private boolean[] visited;

    public int countArrangement(int n) {
        visited = new boolean[n + 1];
        backtrack(n, 1);
        return count;
    }

    private void backtrack(int n, int pos) {
        // Base case: all n numbers are placed
        if (pos > n) {
            count++;
            return;
        }

        // Recursive step: try all unvisited numbers
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                backtrack(n, pos + 1);
                visited[i] = false; // Backtrack
            }
        }
    }
}
