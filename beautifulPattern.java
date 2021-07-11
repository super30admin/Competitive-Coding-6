
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    1. Use backtracking to get different combinations of number.
    2. Check if it's a beautiful number.
*/


// Your code here along with comments explaining your approach
class Solution {
    int count = 0;
    int[] visited;
    int[] perm;
    int length = 0;
    public int countArrangement(int n) {
        visited = new int[n+1];
        perm = new int[n];
        length = n;
        backtrack(0);
        return count;
    }
    
    public void backtrack(int index) {
        if(index == length) {
            count++;
            return;
        }
        int curr = index+1;
        for(int i=1;i<=length;i++) {
            if(visited[i] != 1 && ((i%curr == 0) || (curr%i == 0))) {
                visited[i] = 1;
                // perm[index] = i;
                backtrack(index+1);
                visited[i] = 0;
            }
        }
    }
}
