
// Time Complexity : O(N!)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int count;
    public int countArrangement(int n) {
        if(n == 0 || n == 1)
            return n;
        
        int[] nums = new int[n + 1];
        
        helper(n, 1, nums);
        
        return count;
        
    }
    
    private void helper(int n, int index, int[] nums){
        //base
        if(index > n){
            count++;
            return;
        }
        //logic
        for(int i = 1; i <= n; i++){
            if(nums[i] == 0 && (index % i == 0 || i % index == 0)){
                nums[i] = index;
                //System.out.println(Arrays.toString(nums));
                helper(n, index + 1, nums);
                nums[i] = 0;
            }
        }
    }
}