// Time Complexity :O(possible valid way) --- O(k) 
// Space Complexity :O(n) - depth
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    int cnt = 0;
    public int countArrangement(int n) {
        int[] nums = new int[n];
        //create nums array
        for(int i=0;i<n;i++){
            nums[i] = i+1;
        }
        permute(nums, 0);
        return cnt;
    }
    
    public void permute(int[] nums, int pos){
    	//reaches all position(depth) it is valid permutation
        if(pos == nums.length){
            cnt++;
        }
        for(int i=pos;i<nums.length;i++){
        	//swap index with depth
            swap(nums, i, pos);
            //if condition is true at partcular depth move downwards and create permutations
            if(nums[pos] % (pos+1) == 0 || (pos+1) % nums[pos] == 0)
            
                permute(nums, pos+1);
            swap(nums, i, pos); //backtracking to get original array
            
        }
    }
    
    public void swap(int[] nums, int x, int y){
        int tem = nums[x];
            nums[x] = nums[y];
            nums[y] = tem;
    }
}