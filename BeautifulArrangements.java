// Time: O(No of arrangements) | Space : O(N) at the every level in the recurisive callstack

class Solution {
    int noOfArrangements;
    boolean[] visited;
    public int countArrangement(int n) {
        visited = new boolean[n + 1];
        noOfArrangements = 0;
        helper(n, 1, 1);
        return noOfArrangements;
    }

    private void helper(int n, int index) {
        if (index == n + 1) {
            // only when we hit the last index, meaning taking all the distinct numbers into account satisfying the beautiful arrangement constraint
            // we increment our result
            noOfArrangements++;
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            // same no should be visited again
            // only on "if number can be divided by the index or visa versa" condition, we should consider
            // we are maintaining the index at the call stack itself,
            // we did not have any pivot in place, because at every level, we are to consider all the permutations
            if (!visited[i] && (i % index == 0 || index % i == 0)) {
                // action
                visited[i] = true;
                // recurse
                helper(n, index + 1);
                //backtrack the earlier action
                visited[i] = false;
            }
        }
    }
}