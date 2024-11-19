// Time Complexity :O(k) where k is number of result found
// Space Complexity :O(N) for storing them in int array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

class Solution {
    int count = 0;

    public int countArrangement(int n) {
        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++) arr[i] = i;
        helper(n,arr);
        return count;
    }
    private void helper(int n, int [] arr){
        //base remains same but now decressing so zero
        if(n ==  0){
            count++;
            return;
        }
        //logic of swap
        for(int i = n; i > 0; i--){
            swap(arr, i, n);
            if(arr[n]% n == 0 || n%arr[n] == 0)
                helper(n-1,arr);
            swap(arr, i, n);
        }    
    }
    private void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


/*
//TC O(K) SC O(N)
class Solution {
    int count = 0;
    int arr[];
    public int countArrangement(int n) {
        arr = new int[n+1];
        helper(n,1,arr);
        return count;
    }
    private void helper(int n, int index, int [] arr){
        //base
        if(index > n){
            count++;
            return;
        }
        //logic
        for(int i = 1; i <= n; i++){
            if(arr[i] == 0 && (index%i == 0 || i%index == 0)){
                arr[i] = index;
                helper(n,index+1,arr);
                arr[i]=0;
            }
        }
    }
}
*/