// Time Complexity : O(n!)
// Space Complexity : O(n) ->for visited array
// Did this code successfully run on Leetcode : Yes
public class BeautifulArrangements {
    boolean[] visited;
    int count;
    public int countArrangement(int n) {
        visited = new boolean[n+1];
        helper(n,1);
        return count;
    }

    public void helper(int n, int pivot)
    {
        if(pivot > n)
        {
            count++;
            return;
        }

        for(int i=1; i<=n; i++)
        {
            if(!visited[i] && (i%pivot == 0 || pivot%i == 0))
            {
                visited[i] = true;
                helper(n, pivot+1);
                visited[i] = false;
            }
        }
    }
}
