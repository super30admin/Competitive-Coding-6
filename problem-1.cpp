// https://leetcode.com/problems/beautiful-arrangement/description/
// Time Complexity : O(n!) where n is the input number
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public:
        void helper(int n, vector<int> &ans, int &res, int num){
            if(num == n+1){
                res++;
                return;
            }
            for(int i=1; i<=n; i++){
                if(ans[i] == 0 && (num%i == 0 || i%num == 0)){
                    ans[i] = num;
                    helper(n,ans,res,num+1);
                    ans[i] = 0;
                }
            }
        }
        int countArrangement(int n) {
            vector<int> ans(n+1,0);
            int res=0;
            helper(n,ans,res,1);
            return res;
        }
    };