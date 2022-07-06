
// TC is O(k) where k is the possible permutations
// SC is O(n)
public class BeautifulArrangement {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        backtrack(n,1, visited);
        return count;
    }

    private void backtrack(int n, int pivot, boolean[] visited){
        // base
        if(pivot > n){
            count++;
        }

        // logic
        for(int i=1; i<= n; i++){
            if(!visited[i] && (pivot%i == 0 || i%pivot == 0)){
                // action
            visited[i] = true;
            //recursion
            backtrack(n, pivot+1, visited);
            // backtrack
            visited[i] = false;
            }

        }
    }
}