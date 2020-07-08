// Time Complexity : O(K), where K is number of valid permutations
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
	int count;

	public int countArrangement(int N) {
		count = 0;
		// Initializing a visited array
		int nums[] = new int[N + 1];
		backtrack(N, nums, 1);
		return count;
	}

	private void backtrack(int N, int nums[], int pos) {
		// base
		if (pos > N)
			count++;

		// logic
		for (int i = 1; i <= N; i++) {
			if (nums[i] == 0 && (pos % i == 0 || i % pos == 0)) {
				nums[i] = 1;
				backtrack(N, nums, pos + 1);
				nums[i] = 0;
			}
		}
	}
}