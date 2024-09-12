package competitiveCoding6;

public class BeautifulArrangement {
	//Time Complexity : O(m), where m is the valid permutations
	//Space Complexity : O(n), where n is the depth for visited array
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	int count = 0;
    public int countArrangement(int n) {
        dfs(n, 1, new boolean[n + 1]);
        return count;
    }
    
    private void dfs(int n, int idx, boolean[] visited) {
        // base
        if(idx > n) {
            count++;
            return;
        }
        
        // logic
        for(int i=1; i<=n; i++) {
            if(visited[i])
                continue;
            visited[i] = true;
            if(i % idx == 0 || idx % i == 0)
                dfs(n, idx + 1, visited);
            visited[i] = false;
        }
    }
}
