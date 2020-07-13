//Time complexity:O(n)
//Space complexity:O(n)

public class Solution {
    int count = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        helper(N, 1, visited);
        return count;
    }
    public void helper(int N, int idx, boolean[] visited) {
        if (idx > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (idx % i == 0 || i % idx == 0)) {
                visited[i] = true;
                helper(N, idx + 1, visited);
                visited[i] = false;
            }
        }
    }
}