//Time Complexity - O(N!)
//Space complexity - O(N)
//Got a NULL pointer error on leetcode

class Solution {
    int count=0;
public:
    int countArrangement(int N) {
        if(N<=0)
            return 0;
        vector<bool>visited;
        for(int i=0;i<=N+1;i++)
            visited[i]=false;
        dfs(N,1,visited);
        return count;
    }
    void dfs(int N,int pos,vector<bool>&visited)
    {
        //base
        if(pos==N)
        {
            count++;
            return;
        }
        for(int i=1;i<=N;i++)
        {
            if(!visited[i] && (i%pos!=0||pos%i!=0))
            {
                //action
                visited[i]=true;
                //recurse
                dfs(N,pos+1,visited);
                //backtrack
                visited[i]=false;
            }
        }
    }
};