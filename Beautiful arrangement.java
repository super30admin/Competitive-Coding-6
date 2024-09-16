//Time complexity: O(k)
//Space complexity: O(n)

class Solution {
    int count=0;
    public int countArrangement(int n) {
        boolean visited[]= new boolean[n+1];
        helper(visited, 1, n);
        return count;
    }
    public void helper(boolean[]visited, int val, int n)
    {
        //base
        if(val==n+1)
        {
            
            count++;
            return;
        }
        
        //logic
        for(int i=1;i<=n;i++)
        {
            if(!visited[i] && (val % i==0 || i%val==0))
            {
                visited[i]=true;
                helper(visited, val+1, n);
                 visited[i]=false;
            }
            
           
        }
        
    }
}