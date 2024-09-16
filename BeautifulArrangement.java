public class BeautifulArrangement {

    /*
    TC : O(k). k refers to the number of valid permutations
    SC : O(n). visited array of size nn is used.
     The depth of recursion tree will also go upto n. Here, n refers to the given integer n.
     LeetCode : yes
     Problems faced : No

     */

    /**
     * We used the tree method to create all the permutations of 1 to n and
     * then also maintain visited array to mark which number has been visited ubntil now.
     */
    public int count = 0;
    public boolean[] visited;

    public int countArrangement(int n) {
        visited = new boolean[n + 1];
        helper(n, 1);
        return count;
    }

    public void helper(int n, int index) {
        //base
        if (index >= n + 1)
            count++;

        //logic

        for (int i = 1; i <= n; i++) {
            if ((i % index == 0 || index % i == 0) && !visited[i]) {
                visited[i] = true;
                helper(n, index + 1);
                visited[i] = false;
            }

        }


    }
}
