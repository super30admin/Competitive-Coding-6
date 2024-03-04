// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not sure about the time complexity in the optimized solution

// Your code here along with comments explaining your approach
// Try all possible permutations of the array using swap. Optimization: Check validity after swap
// if it's not valid, dont explore that path.

class BeautifulArrangement {
    int res;

    public int countArrangement(int n) {
        this.res = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        dfs(0, arr);
        return res;
    }

    private void dfs(int index, int[] arr) {
        if (index == arr.length) {
            res++;
        }

        for (int i = index; i < arr.length; i++) {
            // action
            swap(arr, i, index);
            // check if current index is a beautiful arrangement
            // recurse
            if (arr[index] % (index + 1) == 0 || (index + 1) % arr[index] == 0) {
                // index + 1 as we still have to check if i is a beautiful arrangement()
                dfs(index + 1, arr);
            }
            // backtrack
            swap(arr, i, index);
        }
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}