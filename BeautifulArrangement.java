// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Need hints to code, was not fluent with permutation logic
// Approach:
// 1. Generate all permutation using for loop recursion
// 2. Check if the permutation satisfy the beautiful arrangement condition
// - if it does not, do not proceed
// 3. Increment the count at the end of permutation

import java.util.HashSet;
import java.util.Set;

public class BeautifulArrangement {
    int count;
    public int countArrangement(int n) {
        helper(n, 1, new HashSet<>());
        return count;
    }

    void helper(int n, int idx, Set<Integer> numSet){
        if(idx > n) {
            count++;
            return;
        }

        for(int i=1; i<=n; i++) {
            if(!numSet.contains(i)) {
                // check beautiful arrangement
                if(i % idx == 0 || idx % i == 0) {
                    numSet.add(i);
                    helper(n, idx+1, numSet);
                    numSet.remove(i);
                }
            }
        }
    }
}
