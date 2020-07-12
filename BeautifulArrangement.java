
// Time Complexity : O(2*n). n is the given number of elements
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    int count=0;
    public int countArrangement(int N) {
        if(N==0) return 0;
        
        int[] nums = new int[N];
        for(int i=0;i<N;i++){
            nums[i]=i+1;
        }
        
        helper(nums,0);
        return count;
    }
    
    private void helper(int[] nums,int start){
        //boolean isValid=true;
        if(start==nums.length){
             count++;
             return;
                
        }
            
           
           
        
        
        for(int i=start;i<nums.length;i++){
            swap(nums,i,start);
            
            if(nums[start]%(start+1) ==0 || (start+1)%nums[start]==0){
                
               helper(nums,start+1);
                
            }
            swap(nums,start,i); 
            
        }
    }
    
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
