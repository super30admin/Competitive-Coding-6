// Time Complexity : O(m) where m is the no of valid combinations 
// Space Complexity : O(n) for the array with n numbers
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//took an array of size N and populated it with numbers from 1->N
//backTrack function is going to iniitially take arr, N , index 0
//at each level , it is going to fix an element at position 1 and recursively check backTrack function to check for next positions
//whenever index equals the size, we know that the arragement satisfies the condition(because we are checking the combos where it satisfies our condition)
//return the count after the function

class Solution {
    int count=0;
    public int countArrangement(int N) {
        int[] arr=new int[N];
        for(int i=1;i<=N;i++){
            arr[i-1]=i;
        } 
         backTrack(arr, N,0);
        return count;
    }
    private void backTrack(int[] arr,int n, int index){
        //base case
        if(index==n){
            count++;
        }
        //recursive case
        for(int i=index;i<n;i++){
            swap(arr,i,index);
            if(arr[index]%(index+1)==0 || (index+1)%arr[index]==0){
                backTrack(arr,n,index+1);
            }
            swap(arr,i,index);
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}