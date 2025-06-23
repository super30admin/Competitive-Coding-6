// Time Complexity : O(K) k= valid permutations
// Space Complexity : O(n)
/* Approach : we start with a count of zero and use a recursive function to explore all possible ways to arrange numbers from 1 to n 
in positions from 1 to n. For each position, we check if a number can be placed there based on the condition that either the position 
is divisible by the number or the number is divisible by the position. If the number can be placed, we mark it as used and move to the 
next position. If we successfully place all numbers, we increment the count. After trying each number, we backtrack by unmarking it and 
trying the next number, ensuring all valid arrangements are counted.
 */
class Solution {
    int count;

    // This method initializes the count and starts the recursive helper function
    public int countArrangement(int n) {
        this.count = 0;
        boolean[] visited = new boolean[n + 1];
        helper(visited, 1, n);
        return count;
    }

    // This is the recursive helper function that generates the arrangements
    private void helper(boolean[] visited, int pos, int n) {
        // Base case: if the position exceeds n, increment the count
        if (pos > n) {
            count++;
            return;
        }

        // Recursive case: try placing each number from 1 to n at the current position
        for (int i = 1; i <= n; i++) {
            // Check if the number is not visited and satisfies the condition
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true; // Mark the number as visited
                helper(visited, pos + 1, n); // Recur for the next position
                visited[i] = false; // Backtrack and unmark the number
            }
        }
    }
}
