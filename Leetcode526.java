//Solution 1: Backtracking with for loop
// TC - O(n!)
// SC - O(n) recursion stack space
class Solution {
    public int countArrangement(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        int count = helper(nums, 0, new HashSet<>(), new ArrayList<>());

        return count;

    }

    private int helper(int[] nums, int count, HashSet<Integer> set, List<Integer> path) {
        // Base
        if (set.size() == nums.length) {
            count += 1;
            return count;
        }

        // For Loop
        for (int i = 0; i < nums.length; i++) {
            // Action
            int size = set.size();

            boolean isEligible = (nums[i] % (size + 1) == 0) || ((size + 1) % nums[i] == 0);

            if (!set.contains(nums[i]) && isEligible) {
                set.add(nums[i]);
                path.add(nums[i]);

                // Recurse
                count = helper(nums, count, set, path);

                // Backtrack
                set.remove(nums[i]);
                path.remove(path.size() - 1);
            }
        }
        return count;
    }
}