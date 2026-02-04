/*
Time Complexity - O(n!)
Space Complexity - O(n)
 */
public class BeautifulArrangement {
    boolean[] visited;
    public int countArrangement(int n) {
        visited = new boolean[n+1];// to check if the number has already been visited
        return helper(n,1);
    }
    private int helper(int n, int pos) {
        //base case
        if (pos>n) {
            return 1;
        }
        int count = 0;
        //logic
        //generate all permutations of numbers from 1 to n using backtracking.
        for (int i=1; i<=n; i++) {
            //At each position, we only place numbers that satisfy the divisibility condition with that position.
            if (!visited[i] && (i%pos == 0|| pos%i==0)) {
                visited[i] = true; // mark the visited index as true
                count = count + helper(n, pos+1); // recurse
                visited[i] = false; //backtrack
            }
        }
        return count;
    }
    public static void main(String[] args) {
        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        System.out.println(beautifulArrangement.countArrangement(2));
        System.out.println(beautifulArrangement.countArrangement(3));
        System.out.println(beautifulArrangement.countArrangement(5));
    }

}
