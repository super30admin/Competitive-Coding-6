/* Time: o(k) where k = number of possible beautiful arrangements
space: o(n) - depth of array -> no of elements
*/

class Solution {
    int count = 0;
    public int countArrangement(int n) {
        int[] nums = new int[n+1];
        for(int i = 0; i <= n; i++)
            nums[i] = i;
        
        permute(nums, 1);
        return count;
    }
    
    private void permute(int[] nums, int index){
        //base
        if(index == nums.length){
            count++;
            return;
        }
        
        //logic
        for(int i = index; i < nums.length; i++){
            //action
            swap(nums, i, index);
            
            //recurse if conditions meet
            if(nums[index] % index == 0 || index % nums[index] == 0)
                permute(nums, index+1);
            
            //backtrack
            swap(nums, i, index);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
}