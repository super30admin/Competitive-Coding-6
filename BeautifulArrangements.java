// Time Complexity : O(k) where k is the number of valid permutations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Having a boolean array of the length N and iterating in for loop at every stage with backtracking

public class BeautifulArrangements {
    int result = 0;
    public int countArrangement(int N) {

        boolean[] visited = new boolean[N+1];
        helper(N, visited,1);
        return result;
    }

    private void helper(int N, boolean[] visited, int index){

        if(index>N){
            result++;
        }

        for(int i =1;i<=N;i++){
            if(!visited[i]){ //not visited [0 1 0]
                if(index %i ==0 || i % index ==0){ //if cases passed
                    visited[i] = true; //mark that index as visited
                    helper(N,visited, index+1);
                    visited[i] = false; //backtrack to theprevious position by setting
                    // that index to false;
                }
            }
        }

    }
}
