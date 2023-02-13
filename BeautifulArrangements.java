// Time Complexity : O(K), K refers to the number of valid permutations
// Space Complexity : O(N), visited array of size N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BeautifulArrangements {
    int count;

    public int countArrangement(int n) {
        int position[] = new int[n + 1];
        backtrack(1, n, position);
        return count;
    }

    void backtrack(int val, int n, int[] position) {
        if (val > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (position[i] == 0 && (i % val == 0 || val % i == 0)) {
                position[i] = val;
                backtrack(val + 1, n, position);
                position[i] = 0;
            }
        }

    }
}