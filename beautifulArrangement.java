//tc: n!
//sc: o(n)
class Solution {
    int result = 0;
    public int countArrangement(int n) {
        if(n == 0) {
            return result;
        }
        int[] nums = new int[n + 1];
        helper(nums, 1, n);
        return result;
    }
    private void helper(int[] nums, int val, int n) {
        //base
        if(val > n) {
            result++;
            return;
        }
        //logic
        for(int i = 1; i <= n; i++) {
            if(nums[i] == 0 && (val % i == 0 || i % val == 0)) {
              //action
             nums[i] = val;
                //recurse
                helper(nums, val + 1, n);
                //backtrack
                nums[i] = 0;
            }   
        }
    }
}