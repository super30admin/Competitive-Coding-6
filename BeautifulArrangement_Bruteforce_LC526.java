// Time Complexity : O(n * n!) n! = permutations
// Space Complexity : O(n) n = nums length
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES

class BeautifulArrangement_Bruteforce_LC526 {
    int count = 0;

    public int countArrangement(int n) {
        int[] init = new int[n];
        
        for (int i = 0; i < n; i++) {
            init[i] = i + 1;
        }

        return backTrack(init, 0);  
    }

    private int backTrack(int[] init, int l){

        //base case
        if (l == init.length - 1) {
            int k;
            for (k = 1; k <= init.length; k++) {
                if ((init[k - 1] % k != 0) && (k % init[k - 1] != 0)) break;
            }

            if (k == init.length + 1) count++;
        }
        

        for (int i = l; i < init.length; i++) {
            swap(init, i, l);
            backTrack(init, l + 1);
            swap(init, i, l);
        }
        return count;
    }

    private void swap(int[] init, int x, int y) {
        int temp = init[x];
        init[x] = init[y];
        init[y] = temp;
    }

}