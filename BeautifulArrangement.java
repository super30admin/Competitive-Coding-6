//https://leetcode.com/problems/beautiful-arrangement/
/*
Time: O(K) where K = number of valid permutations
Space: O(n) n = size of 'used' array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class BeautifulArrangement {

    int count = 0;

    public int countArrangement(int n) {

        boolean[] used = new boolean[n + 1];
        // Here, used[i] refers to the ith number being already placed/not placed in the
        // array being formed till now
        backtrack(n, 1, used);

        return count;
    }

    public void backtrack(int n, int val, boolean[] used) {
        if (val > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i] && (val % i == 0 || i % val == 0)) {
                used[i] = true;
                backtrack(n, val + 1, used);
                used[i] = false;
            }
        }
    }

}
