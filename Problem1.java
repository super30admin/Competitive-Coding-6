//time o(n!), n is i/p, for each number, begining from first is 1 has n * n-1 * n-2 .....possibilties

//space recursive stack, o(n)
class Solution {
    int res;
    public int countArrangement(int N) {
        if(N == 0)
            return 0;
        
        int[] arr= new int[N+1];
        for(int i=0;i<=N;i++) {
            arr[i] = i;
        }
        
        backtrack(arr, 1);
        return res;
    }
    
    private void backtrack(int[] arr, int first) {
        //base case
            if(first == arr.length) {
                res++;
                return;
            }
        //logic
        for(int i=first;i<arr.length;i++) {
            //action 
            swap(arr, first, i);
            //recurse
            int x = arr[first];
            if(x%first == 0 || first%x == 0){
                backtrack(arr, first+1);
            }
            //backtrack
            swap(arr, i, first);
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}