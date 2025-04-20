public class BeautifulArrangement {
    int res;
    boolean[] visited;

    public int countArrangement(int n) {
        this.res = 0;
        this.visited = new boolean[n + 1]; // as index starts from 1

        dfs(n, 1);
        return res;
    }

    private void dfs(int n, int pos) {
        //base case
        if (pos > n) {
            res++;
            return;
        }

        for (int i = 1; i <= n; i++) {

            //action
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;

                //recurse
                dfs(n, pos + 1);

                //backtrack
                visited[i] = false;
            }
        }
    }
}

//TC: O(k) - valid permutations, worst case: O(n!)
//SC: O(h) + O(n)
