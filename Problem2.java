// Time Complexity : O(n!) recursion and backtracking takes O(n!) time
// Space Complexity : O(n) where n is the input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    int count;
    public int countArrangement(int n) {
        if(n == 0){
            return 0;
        }

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }

        count = 0;

        backtrack(arr, n, 0);

        return count;
    }

    private void backtrack(int[] arr, int n, int index){

        if(index == n){
            count++;
        }



        //logic
        for(int i = index; i < n; i++){
            //action
            swap(arr, index, i);

            //recurse
            if((arr[index] % (index+1) == 0) || ((index+1) % arr[index] == 0)){
                backtrack(arr, n, index+1);
            }


            //backtrack
            swap(arr, index, i);
            //[1,2,3,4] [1,3,2,4], [1,2,3,4]
        }

    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
