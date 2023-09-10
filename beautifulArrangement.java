// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
class Solution {
    boolean[] arr;
    int count;
    public int countArrangement(int N) {   
        arr = new boolean[N+1];
        count = 0; 
        backtrack(arr, N, 1);  
        return count; 
    }
    
    private void backtrack(boolean[] arr, int N, int index) {
        if(index > N) {
            count++; 
            return; 
        }
        
        for(int i = 1; i <= N; i++) {
            if(arr[i] != true) {
                if( i % index == 0 || index % i == 0 ) {
                    arr[i] = true;
                    backtrack(arr, N, index+1);
                    arr[i] = false; 
                }
            } 
        }
    }
}