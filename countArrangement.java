// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Main {
    // to maintain a count of beautiful arrangement
    private static int count;

    public static int countArrangement(int n) {
        count = 0;
        boolean[] visited = new boolean[n + 1];
        backTrack(1, n, visited);
        return count;
    }

    private static void backTrack(int index, int n, boolean[] visited) {

        // base case
        if (index > n) {
            count++;
            return;
        }

        // main logic
        for (int i = 1; i <= n; i++) {
            // if element is not visited and it is beautiful then we make it visited and
            // recurse
            if (!visited[i] && (index % i == 0 || i % index == 0)) {
                // action
                visited[i] = true;
                // recurse
                backTrack(index + 1, n, visited);
                // backtrack
                visited[i] = false;

            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countArrangement(3));
    }
}