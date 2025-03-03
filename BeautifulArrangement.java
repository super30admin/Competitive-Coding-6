// TimeComplexity: O(k) where k is the number of valid permutations
// SpaceComplexity: O(n) where n is the number of elements in the array used for visited array

class BeautifulArrangement {
    public int countArrangement(int n) {
        // edge case
        if(n == 1){
            return 1;
        }

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }

        boolean[] visited = new boolean[n];

        return backtrack(n, arr, 0, visited);

    }

    private int backtrack(int n, int[] arr, int pivot, boolean[] visited){
        // base case
        if(pivot == n){
            return 1;
        }

        int count = 0;
        // flow
        for(int i = 1; i <= n; i++){
            if(!visited[i-1] && ((arr[i-1]%(pivot+1) == 0) || ((pivot+1) % arr[i-1] == 0))){
                visited[i-1] = true;
                count += backtrack(n, arr, pivot+1, visited);
                visited[i-1] = false;
            }
        }
        return count;
    }
}
