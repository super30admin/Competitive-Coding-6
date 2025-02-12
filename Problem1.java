class Solution {
    int count;

    public int countArrangement(int n) {
        if (n == 0) {
            return 0;
        }
        count = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        recurse(nums, 0);
        return count;
    }

    private void recurse(int[] nums, int index) {
        // base
        if (index == nums.length) {
            count++;
            return;
        }

        // logic
        for (int i = index; i < nums.length; i++) {
            // action
            swap(nums, i, index);
            // recurse
            if (nums[index] % (index + 1) == 0 || (index + 1) % nums[index] == 0) {
                recurse(nums, index + 1);
            }

            // backTrack
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}