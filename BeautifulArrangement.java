// Time Complexity : O(n!) --> where n is the input number 
// Space Complexity : O(n) (recursion stack space)
// Did this code successfully run on Leetcode (526) : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int count;
    public int countArrangement(int N) {
        count = 0;   
        if (N <= 0) return count; // edge case
        
        boolean visited[] = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }
    
    private void calculate(int N, int pos, boolean visited[]) {
        // base case
        if (pos > N) count++;
        
        // logic
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;  // action
                calculate(N, pos + 1, visited);  // recurse
                visited[i] = false;  // backtrack
            } 
        }
    }
}