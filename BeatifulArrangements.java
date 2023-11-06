// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class BeatifulArrangements {
    int result = 0;
    public int countArrangement(int N)
    {
        boolean[] visited = new boolean[N + 1];
        permute(N, 1, visited);
        return result;
    }
    public void permute(int N, int pivot, boolean[] visited)
    {
        if (pivot > N)
            result++;
        for (int i = 1; i <= N; i++)
        {
            if (!visited[i] && (pivot % i == 0 || i % pivot == 0)) {
                visited[i] = true;
                permute(N, pivot + 1, visited);
                visited[i] = false;
            }
        }
    }
}
