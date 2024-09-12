//time complexity:O(k)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using backtracking
//any issues faced? no

class Solution {
public:
    int count=0;
    int countArrangement(int N) {
        vector<bool>used(N);
        dfs(N,used,1);
        return count;
    }
    void dfs(int N, vector<bool>& used, int pos)
    {
        if(pos>N)
            count++;
        for(int i=1; i<=N; i++)
        {
            if(used[i]==true)
                continue;
            else if(i%pos==0 || pos%i==0)
            {
                used[i]=true;
                dfs(N,used,pos+1);
                used[i]=false;
            }
        }
    }
};