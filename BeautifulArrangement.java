//Time Complexity:O(n!)
//Space Complexity: O(n!)
class Solution {
    int[] arr;
    int countNo;
    public int countArrangement(int n) {
        arr = new int[n+1];
        countNo = 0;
        if(n==1) return 1;
        for(int i = 1;i<=n;i++)
            arr[i] = i;
        helper(arr, 1);
        return countNo;
    }

    private void helper(int[] arr, int pivot){
        //base case
        if(pivot == arr.length)
        {
            countNo++;
            return;
        }
        for(int i=pivot;i<arr.length;i++){
            swap(arr,pivot,i);
            if(arr[pivot]%pivot==0 || pivot%arr[pivot]==0)
                helper(arr,pivot+1);
            swap(arr,i,pivot);
        }
    }
    private void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}