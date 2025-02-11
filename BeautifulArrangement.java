//TC: O(n!)
//SC: O(n) each for visited array and for recursive stack space
//approach: backtracking
public class BeautifulArrangement {
    int count;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n];
        backtrack(n, 1, visited);
        return count;
    }

    private void backtrack(int n, int level, boolean[] visited) {
        //base case
        System.out.println(level);
        if (level == n + 1) {
            count++;
            return;
        }
        //logic
        for (int j = 1; j <= n; j++) {
            if (isBeautiful(j, level) && !visited[j - 1]) {
                visited[j - 1] = true;
                backtrack(n, level + 1, visited);
                //backtrack
                visited[j - 1] = false;
            }
        }
    }

    private boolean isBeautiful(int i, int index) {
        return ((i % index == 0) || (index % i == 0));
    }
}

