//Time Complexity: O(n!) because we are trying to get permutations which make a beautiful arrangement
//Space Complexity: O(n) for the visited array
public class BeautifulArrangement {

    public int countArrangement(int n) {
        return dfs(n, new boolean[n + 1], 1);
    }

    private int dfs(int n, boolean[] visited, int position) {
        if (position > n) {
            return 1;
        }

        int output = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            if ((i % position == 0) || (position % i == 0)) {
                visited[i] = true;
                output += dfs(n, visited, position + 1);
                visited[i] = false;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        final BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        System.out.println(beautifulArrangement.countArrangement(3)); //3
        System.out.println(beautifulArrangement.countArrangement(1)); //1
    }
}
