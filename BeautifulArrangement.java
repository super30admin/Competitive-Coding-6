// Time Complexity : O(k) k is the permutations, aka result
// Space Complexity : O(N) N is n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Understanding the problem

// Your code here along with comments explaining your approach: exhaustive approach with backtracking using dfs. If [i]%i and vv is 0 then call dfs

public class BeautifulArrangement {
    int res = 0;

    public int countArrangement(int n) {
        if (n == 0)
            return 0;
        int[] arr = new int[n + 1];

        for (int i = 1; i < arr.length; i++)
            arr[i] = i;

        dfs(arr, n);
        return res;
    }

    private void dfs(int[] arr, int val) {
        // base
        if (val == 0) {
            res++;
            return;
        }

        // logic
        for (int i = val; i > 0; i--) {
            swap(arr, i, val);

            if (val % arr[val] == 0 || arr[val] % val == 0)
                dfs(arr, val - 1);

            // backtracking
            swap(arr, i, val);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}