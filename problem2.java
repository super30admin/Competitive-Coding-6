
// Time Complexity : O(2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * Approach
 * 
 * here we are using a for loop based recusion
 * building out paths for each permutation
 * but before we add an element to the path we check if the 
 * element we are adding to the path should not be in the path already
 * and the element being added is perfectly divisible by the path size()+1 (to maintain the Beautiful Arrangement property) 
 * 
 * we increase the result by 1 when path size is equal to N
 */

class Solution {
    private int result = 0;

    public int countArrangement(int n) {
        backtrack(n, new ArrayList<>());
        return result;
    }

    private void backtrack(int n, List<Integer> path) {
        // base
        if (path.size() == n) {
            result++;
            return;
        }

        // logic
        int pos = path.size() + 1;
        for (int i = 1; i <= n; i++) {
            if (path.contains(i))
                continue;
            if (i % pos != 0 && pos % i != 0)
                continue;
            path.add(i);
            backtrack(n, path);
            path.remove(path.size() - 1);
        }

    }
}