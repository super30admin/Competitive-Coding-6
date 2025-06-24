// Time Complexity : O(K) where K is slightly less than n! since we are filtering out invalid arrangements early
// Space Complexity : O(n) for the recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BeautifulArrangement {
    int count;

    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1];
        helper(n, used, 1);
        return count;
    }

    private void helper(int n, boolean[] used, int pivot) { // 4
        // base
        if (pivot > n) {
            count++;
            return;
        }

        // logic
        for (int i = 1; i <= n; i++) {
            if (!used[i] && (pivot % i == 0 || i % pivot == 0)) {
                used[i] = true;
                helper(n, used, pivot + 1);
                used[i] = false;
            }
        }
    }
}
