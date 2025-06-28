// Time Complexity : O(H) H = permutations
// Space Complexity : O(n) n = nums length
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES

public class BeautifulArrangement_LC526 {

    int count = 0;
    public int countArrangement(int n) {
        int[] nums = new int[n + 1];

        backtrack(nums, 1, n);
        return count;
    }

    private void backtrack(int[] nums, int pos, int n){

        if (pos > n) {
            count++;
            return;
        }


        for (int i = 1; i <= n; i++) {
            if (nums[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                nums[i] = pos;
                backtrack(nums, pos + 1, n);
                nums[i] = 0;
            }
        }
    }
}
