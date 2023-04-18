// the time complexity of this implementation is O(k)
class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return count;
    }

    private void backtrack(int n, int pos, boolean[] visited) {
        if (pos > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                backtrack(n, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 2;
        int count1 = solution.countArrangement(n1);
        System.out.println("The number of beautiful arrangements for n = " + n1 + " is " + count1);

    }
}
