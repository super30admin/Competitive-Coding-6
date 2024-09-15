// Time - O(M), M being the unique possible combinations
// Space - O(N),N for the visited array
    
class Solution {
    int result = 0;
    public int countArrangement(int N) {
        
        if(N == 1) {
            return 1;
        }
        boolean[] visited = new boolean[N+1];
        helper(N, 1, visited);
        
        return result;
    }
    
    private void helper(int N, int index, boolean[] visited) {
        
        if(index > N) {
            result++;
        }
        
        for(int i=1;i<=N;i++) {
            if(!visited[i] && (index % i ==0 || i % index == 0)) {
                visited[i] = true;
                helper(N, index + 1, visited);
                visited[i] = false;
            }
        }
        
    }
}
