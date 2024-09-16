// Time Complexity : O(n!)
// Space Complexity : O(n)

class Solution {
    boolean[]  visited;
    int count;
    
    public int countArrangement(int n) {
        visited = new boolean[n + 1];
        helper(n, 1, visited);
        return count;
    }
    
    private void helper(int n, int index, boolean[] visited){
        //base
        if(index == visited.length){
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