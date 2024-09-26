// Time Complexity: O(n) where number of integers till number given
// Space Complexity: O(n) for recursive stack and Visited array
// Write your approach here
// Idea here is to use a visited array which holds which values are already used for the probability
// On performing DFS with condition that a number is not already visited
// and element is divible by index or index is divisible by element
// one reaching to base condition of 1 probability, (with or without correct probability)
// we backtrack by sessing visited to false and on correct probability we increment result value
class Solution {
    int result = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        dfs(n, 1, visited);
        return result;
    }
    
    public void dfs(int n, int element, boolean[] visited) {
        // base
        if(element > n) {
            result++;
        }
        
        // logic
        for(int i = 1; i<=n; i++) {
            if(!visited[i] && (element%i==0 || i%element==0)) {
                // visited to be true
                visited[i] = true;
                // dfs
                dfs(n, element+1, visited);
                // backtracking
                visited[i] = false;
            }
        }
    }
}