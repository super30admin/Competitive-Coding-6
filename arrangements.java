// Time Complexity : O(2^n) exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int count; // globally define count as we increase it in our backtrack function

    public int countArrangement(int n) {
        if (n == 0) {
            return 0;
        }
        count = 0;
        int[] perm = new int[n]; // initialising the perm array
        for (int i = 0; i < n; i++) {
            perm[i] = i + 1;
        }
        backtrack(perm, 0, n); // call the recursive function with index as 0
        return count;
    }

    private void backtrack(int[] perm, int index, int n) {
        // base
        if (index == n) { // reached end of tree
            count++;
        }

        for (int i = index; i < n; i++) {
            //action
            swap(perm, index, i); // swap , index with index in first loop, later swap with latter elements
            if (((index + 1) % perm[index] == 0) || (perm[index] % (index + 1) == 0)) { // only check with the index element, not i.
                // recurse
                backtrack(perm, index + 1, n);
            }
            swap(perm, i, index); // backtrack
        }

    }

    private void swap(int[] perm, int i, int j) { // swap function
        int temp = perm[i];
        perm[i] = perm[j];
        perm[j] = temp;
    }
}