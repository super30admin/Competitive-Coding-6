// Time Complexity: O(n^3)
// Space Complexity: O(1)
class Solution {
    public int countArrangement(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int cnt=1;
        // construct the arr
        int []arr = new int[n+1];
        for(int i=1;i<n+1;i++){
            arr[i]=i;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=i+1;j<n+1;j++){
                //swap
                arr=swap(arr,i,j);
                //isValid
                if(isValid(arr)){
                    cnt++;
                }
               arr= swap(arr,i,j);
            }
        }
        return cnt;
    }
    
    private boolean isValid(int []arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]%i!=0 && i%arr[i]!=0){
                return false;
            }
        }
        return true;
    }
    
    private int[] swap(int [] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }
}
