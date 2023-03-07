// TC: O(N!) where N is valid palindromes
// SC: O(h) where h is the height of stack

class Solution {
public:
    int count=0;
    int countArrangement(int n) {
        if(n==1)
            return 1;
        vector<int> nums;
        for(int i=1; i<=n; i++)
            nums.push_back(i);
        helper(nums, 0);
        return count;
    }

    //helper
    void helper(vector<int> nums, int index){
        //base condition
        if(index == nums.size()){
            count++;
            return;
        }
        //iterative recursion
        for(int i= index; i< nums.size(); i++){
            // check valid
            if(nums[i] % (index+1) == 0 || (index+1) % nums[i] ==0 ){
                //action
                swap(nums[index], nums[i]);
                //recurse
                helper(nums, index+1);
                //backtrack
                swap(nums[i], nums[index]);
            }
        }
    }
};