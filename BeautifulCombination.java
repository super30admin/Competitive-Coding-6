//TC : O(K) where K is all permutation of n
//SC : O(N) size of visited array we created
class Solution {
    int ctr = 0;
    public int countArrangement(int n) {
        if(n==0) return ctr;

        helper(n,1,new boolean[n+1]);

        return ctr;
    }

    private void helper(int n,int index,boolean[] visited)
    {
        //base
        if(index > n)
            ctr++;
        //logic
        for(int i=1;i<=n;i++)
        {
            if(visited[i]!=true && (i%index==0||index%i==0))
            {
                visited[i] = true;
                helper(n,index+1,visited);
                visited[i] = false;
            }
        }
    }
}