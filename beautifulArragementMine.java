// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    
    int count = 0;
    public int countArrangement(int n) {
        if(n == 0)
            return 0;
        
       int[] arr = new int[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = i;
        }
        helper(n, 1, arr);
        return count;
    }
    
    private void helper(int n, int start, int[] arr){
        //base
        if(start > n){
            count++;
            return;
        }
        //logic
        for(int i=start; i<=n; i++){
            swap(arr,start, i);
            if(arr[start] % start == 0 || start % arr[start] == 0) {
                helper(n, start+1, arr);
            }
            swap(arr,i,start);
        }
        
    }
    
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}