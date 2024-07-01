
// Time Complexity :(n!)
// Space Complexity :(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    int count;
    
    public int countArrangement(int n) {
        if(n == 0){
            return 0;
        }
        int []arr = new int[n+1];
        for(int j=1; j< n+1; j++){
            arr[j] = j;
        }
        backtrack(arr,1);
        return count;
    }

    private void backtrack(int[] arr, int index){
        //base
        if(index == arr.length){
            count++;
            return;
        }

        //logic
        for(int i = index; i< arr.length; i++){

            //check condtion as per problem
            if((arr[i] % index == 0) || (index % arr[i] == 0)){
            swap(arr, index, i);
            
            backtrack(arr, index+1);
            
            //backtracking
            swap(arr, i, index);
            }
        }
    }

    private void swap(int []arr, int m, int n){
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}