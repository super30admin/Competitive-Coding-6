
// Time Complexity : o(k)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    
    int count;

    public int countArrangement(int n) {
       boolean[] visited = new boolean[n + 1]; // coz we are starting from index 1
        helper(n, 1, visited);
        return count;
    }

    private void helper(int n, int index, boolean[] visited){
        //base
        if(index > n){
            count++;
            return;
        }

        //logic
        for(int i = 1; i <= n; i++){
            if(!visited[i] && (index % i == 0 || i % index == 0)){
                visited[i] = true;
                helper(n, index + 1, visited);
                visited[i] = false;
            }
        }
    }
} 
