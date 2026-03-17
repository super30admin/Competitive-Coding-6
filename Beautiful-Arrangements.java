// Time Complexity : O(n!) 
// Space Complexity : O(n)

class Solution {
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        
        return evalArrangements(1, n, visited);
    }
    
    private int evalArrangements(int i, int n, boolean[] visited) {
        // base case
        if (i > n) {
            return 1;
        }

        int count = 0;
        for (int num = 1; num <= n; num++) {
            if (!visited[num] && (i % num == 0 || num % i == 0)) {
                visited[num] = true;
                // recurse
                count += evalArrangements(i+1, n, visited);
                // backtrack
                visited[num] = false;
            }
        }
        return count;
    }
}