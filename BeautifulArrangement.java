//Time complexity: O(n!)
//Space complexity: O(n)

class Solution {
    int arrangements; 
    boolean[] visited;
    public int countArrangement(int n) {
        if(n <= 0) return 0;
        visited = new boolean[n+1];
        helper(n, 1); 
        return arrangements; 
    }
    
    public void helper(int n, int index) {
        //base case
        if(index > n) {
            arrangements++;
        }
        
        //logic
        for(Integer element=1; element<=n; element++) {
            if(!visited[element] && (element % index == 0 || index % element == 0)) {
                //add
                visited[element] = true; 
                //recurse
                helper(n, index+1); 
                //backtrack
                visited[element] = false;
            }
        }
    }
    
}
