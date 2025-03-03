// In this problem, keeping an index on the ith element, and running a loop, if index%i or vice-versa is 0, then marking it as 1
// in the path, and making a recursive call for next index. When this recursive call is completed, backtracking and marking it as
// 0 in path. Whenever our index becomes > n, we have one beautiful combination, so increasing the count.

// TimeComplexity: O(k) where k is the number of valid permutations. O(n!) (factorial due to backtracking)
// SpaceComplexity: O(n) where n is the number of elements in the array used for visited array

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, create a boolean array of size n+1 and use helper function with n and start from index 1 with boolean array. When index crosses n
 * add 1 to count. For every recursive call check with index + 1. Finally return count.
 */

class BeautifulArrangement {
    int result = 0;
    public int countArrangement(int n) {

        if(n <= 0) {
            return result;
        }

        int[] nums  = new int[n+1];
        helper(nums, 1, n);

        return result;
    }

    private void helper(int[] nums, int val, int n)
    {
        if(val > n) {
            result++;
            return;
        }

        for(int i = 1; i<= n; i++) {

            if(nums[i] == 0 && (val % i == 0 || i %val == 0)) {
                nums[i] = 1;
                helper(nums, val + 1, n);
                nums[i] = 0;
            }
        }
    }
}