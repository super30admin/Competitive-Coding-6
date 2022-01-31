// Time Complexity : O(v) where v = number of valid permutations
// Space Complexity : O(n) where n = number
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int counter = 0;
    public int countArrangement(int n) {
        if(n == 0) return 0;
        boolean[] visited = new boolean[n+1];
        helper(n, visited, 1);
        return counter;
    }
    
    private void helper(int n, boolean[] visited, int index){
        // base
        if(index > n){
            counter++;
        }
        
        // logic
        for(int i = 1; i <= n; i++){
            // System.out.println("Outside if : "+ i);
            if(!visited[i] && (i % index == 0 || index % i == 0)){
                // System.out.println("Inside if : "+ i);
                // System.out.println("Index : " + index);
                // action
                visited[i] = true;
                // action
                helper(n, visited, index + 1);
                // backtrack
                visited[i] = false;
              }
        }
        // System.out.println("--------------");
    }
}

