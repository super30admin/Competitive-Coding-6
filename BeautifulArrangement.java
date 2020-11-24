/**
 * Time: O(n!)
 * Space: O(n) - N is number of element from 1-N
 * Approach: Find all possible combination using backtracking. Filter the results using given condition.
 * Increment the count for all valid inputs, return the count.
 */
class Solution {
    HashSet<Integer> tempSet;
    int count = 0;

    public int countArrangement(int N) {
        //edge
        if (N <= 0) return 0;
        tempSet = new HashSet();
        backtrack(N, 1, tempSet);
        return count;
    }

    private void backtrack(int N, int i, HashSet<Integer> tempSet) {
        if (tempSet.size() % i != 0 && i % tempSet.size() != 0) {
            return;
        }

        if (tempSet.size() == N) {
            count += 1;
            return;
        }
        for (int k = 1; k <= N; k++) {
            if (!tempSet.contains(k)) {
                tempSet.add(k);
                backtrack(N, k, tempSet);
                tempSet.remove(k);
            }
        }
    }
}