// Time Complexity :  O(N!) -> Exponential
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    int count = 0;
    public int countArrangement(int N) {
        if( N <= 0)
            return 0;

        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;

    }

    public void calculate(int N, int pos, boolean[] visited) {


        if (pos > N)
            count++;

        for (int i = 1; i <= N; i++) {

            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {

                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;

            }
        }
    }

}

