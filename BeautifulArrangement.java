class Solution {
    // Time Complexity : O(k), where k is the no of valid permutations
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach - Using backtracking - for loop recursion
    int count = 0;
    public int countArrangement(int n) {
        int[] arr = new int[n];
        for(int k = 0; k < n; k++) {
            arr[k] = k+1;
        }
        helper(0, n, new ArrayList<>(), arr);
        return count;
    }
    //index is the pos in the perm arr
    public void helper(int index, int n, List<Integer> path, int[] arr) {
        if(index == n) {
            count++;
            return;
        }

        for(int j = 0; j < n; j++) {
            if(!path.contains(arr[j]) && (arr[j] % (index+1) == 0 || (index+1)%arr[j] == 0)) {
                path.add(arr[j]);
                helper(index+1, n, path, arr);
                path.remove(path.size()-1);
            }
        }
    }

}