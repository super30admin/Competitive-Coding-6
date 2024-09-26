// Time Complexity : O(n!) where n is the input
// Space Complexity : O(n) where n is the input
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

import java.util.HashSet;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    int count = 0;

    public int countArrangement(int n) {
        helper(n);
        return count;
    }

    public void helper(int n) {
        // base
        if (set.size() == n) {
            count += 1;
        }

        // logic
        for (int i = 1; i <= n; i += 1) {
            // if set doesn't contain i and if i satisfies the beautiful arrangement
            // condition then enter the if condition
            if (!set.contains(i) && (i % (set.size() + 1) == 0 || (set.size() + 1) % i == 0)) {
                // action
                set.add(i);
                // recurse
                helper(n);
                // backtrack
                set.remove(i);
            }
        }
    }
}