// Time Complexity :O(n!) 
// Space Complexity : O(h) where h is height of the tree  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int count = 0;
public:
    int countArrangement(int n) {
        vector<int> path;
        backtrack(n,path);
        return count;
    }
    void backtrack(int n, vector<int>& path){
        //base
        if(n == path.size()){
            count++;
            return;
        }
        //logic
        for(int i = 1;i<=n;i++){
            int l = path.size()+1;
            if((l%i == 0 || i%l == 0) && find(path.begin(),path.end(),i) == path.end()){
                path.push_back(i);
                backtrack(n,path);
                path.pop_back();
            }
        }
    }
};