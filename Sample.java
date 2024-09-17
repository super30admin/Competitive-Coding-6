//****BEAUTIFUL ARRANGEMENTS****
// Time Complexity :2^N
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO

class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] arr = new boolean[n+1];
        helper(n,1, arr);
        return count;
    }
    private void helper(int n, int pivot, boolean[] arr){
        // base
        if(pivot > n){
            count++;
        }
        // logic
        for(int i=1; i<= n; i++){
            if(!arr[i] && (pivot%i == 0 || i%pivot == 0)){
                // action
            arr[i] = true;
            //recursion
            helper(n, pivot+1, arr);
            // backtrack
            arr[i] = false;
            }
        }
    }
}


// Your code here along with comments explaining your approach
