// Time Complexity : O(m) where m is no of beautiful arrangements
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class Solution {
    
    int ans = 0;
    int vis[];
    public int countArrangement(int n) {
        vis = new int[n+1];
        backtrack(1, n);
        return ans;
    }
    
    
    public void backtrack(int pos, int n) {
        
        if(pos==n+1) {
            ans++;
            return;
        }
        
        for(int i = 1;i<=n;i++) {
            
            if(vis[i]==1 || pos%i!=0 && i%pos!=0) continue;
            vis[i]=1;
            backtrack(pos+1, n);
            vis[i]=0;
            
        }
        
    }

    
}


