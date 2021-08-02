// Time Complexity : O(k) number of permutations
// Space Complexity : O(n) array of size n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

Beautiful Arrangement

        Suppose you have n integers labeled 1through n.A permutation of those n integers perm(1-indexed)is considered a beautiful arrangement if for every i(1<=i<=n),either of the following is true:

        perm[i]is divisible by i.
        i is divisible by perm[i].
        Given an integer n,return the number of the beautiful arrangements that you can construct.


        Example 1:

        Input:n=2
        Output:2
        Explanation:
        The first beautiful arrangement is[1,2]:
        -perm[1]=1is divisible by i=1
        -perm[2]=2is divisible by i=2
        The second beautiful arrangement is[2,1]:
        -perm[1]=2is divisible by i=1
        -i=2is divisible by perm[2]=1
        Example 2:

        Input:n=1
        Output:1


        Constraints:

        1<=n<=15

class Solution {
    int result = 0;
    int[] nums;

    public int countArrangement(int n) {
        if (n < 1) return result;
        nums = new int[n + 1];
        helper(1, n);
        return result;
    }

    private void helper(int index, int n) {
        //base
        if (index > n) {
            result++;
            return;
        }
        //logic
        for (int i = 1; i <= n; i++) {
            if (nums[i] == 0 && (index % i == 0 || i % index == 0)) {
                nums[i] = index;
                helper(index + 1, n);
                nums[i] = 0;

            }
        }
    }
}