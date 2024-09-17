// TC - O(n!)
// SC - O(n)
// Leetcode URL : https://leetcode.com/problems/beautiful-arrangement

public class BeautifulArrangements {
    int count=0;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        helper(n,1,visited);
        return count;
    }

    public void helper(int n, int pivot, boolean[] visited ){
        // base
        if (pivot>n) {
            count++;
        }

        // logic
        for(int i=1; i<=n ;i++){
            if( visited[i] == false && (pivot%i == 0 || i%pivot == 0)) {
                //action
                visited[i] = true;
                // recursion
                helper(n,pivot+1,visited);
                // backtracking
                visited[i] = false;
            }
        }

    }
}
