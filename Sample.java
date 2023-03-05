
// Time Complexity : O(N!)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Generate all permutations by using an array and putting each element if it
 * satifies the given conditations. If the array is filled, then we can update
 * the count of beautiful arrangements and return this count.
 *
 */
class Solution {
	int count;

	public int countArrangement(int n) {
		int[] nums = new int[n + 1]; // ignoring 0th index
		helper(nums, 1);
		return count;
	}

	public void helper(int[] nums, int start) {
		// base
		if (start == nums.length) {
			count++;
			return;
		}
		// 0 0 0 0
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == 0 && (start % i == 0 || i % start == 0)) {
				nums[i] = start;
				helper(nums, start + 1);
				nums[i] = 0; // backtrack
			}
		}
	}
}
