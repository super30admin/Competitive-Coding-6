public class BeautifulArrangement {

    //For loop recursion using backtracking approach
    //Time complexity - 0(N!) but less than n2
    //Space complexity - O(n)
    class Solution {
        int result=0;
        public int countArrangement(int n) {
            int[] arr = new int[n+1];
            for(int i=0; i<n; i++){
                arr[i] = i+1;
                System.out.println(arr[i]);
            }
            helper(arr, 1);
            return result;
        }

        public void helper(int[] arr, int idx){
            //base condition
            if(idx==arr.length){
                result++;
                return;
            }
            for(int j = idx; j<arr.length; j++){
                if(arr[j]%idx==0 || idx%arr[j]==0){
                    swap(arr, j, idx);
                    helper(arr, idx+1);
                    swap(arr,idx, j);
                }
            }
        }

        public void swap(int[] arr, int i, int j){
            if(i==j){return;}
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
