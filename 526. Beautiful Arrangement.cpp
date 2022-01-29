// Time Complexity : O(Exponential)
// Space Complexity : O(Exponential)
//The set data structure is not time efficient try to use vector or array if possible.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
public:
    int count=0;
    int countArrangement(int n) {
        int nums[16] = {0};
        helper(n, 1, nums);
        return count;
    }
    void helper(int n, int index, int nums[]){
        //base case
        if(index>n){
            count++;
            return;
        }
        //logic
        for(int i=1;i<=n;i++){
            if(nums[i]==0  && ((index%i)==0 || (i%index)==0)){
                //action
                nums[i]=i;
                //recurse
                helper(n,index+1,nums);
                //backtrack
                nums[i]=0;
            }
        }
    }
};
