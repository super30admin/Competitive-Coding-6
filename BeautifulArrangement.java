
// Time Complexity : O(k) k-no of permutations
// Space Complexity : O(d) n- depth of the recurssion tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Permutations
 */
public class Solution {

    int count = 0;

    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }

    public void calculate(int N, int pos, boolean[] visited) {
        if (pos > N) {
            count++;
            return;
        }

        for (int number = 1; number <= N; number++) {
            if (!visited[number] && (pos % number == 0 || number % pos == 0)) {
                visited[number] = true;
                calculate(N, pos + 1, visited);
                visited[number] = false;
            }
        }
    }
}
