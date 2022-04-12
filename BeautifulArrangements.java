/**
 * time and space complexity is exponential
 */
class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        permute(1, n, visited);
        return count;
    }
    private void permute(int pos, int n, boolean[] visited) {
        if(pos > n) {
            count++;
        }
        
        for(int i = 1; i <= n; i++) {
            if(!visited[i] && (i%pos == 0 || pos%i == 0)) {
                visited[i] = true;
                permute(pos+1, n, visited);
                visited[i] = false;
            }
        }
    }
}