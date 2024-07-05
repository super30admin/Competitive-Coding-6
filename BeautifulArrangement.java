//Time Complexity - number of permutations - O(n! * n ) - n for the swap operations
//Space Complexity - O(n) - creation of array
class Solution {
    int count;
    public int countArrangement(int n) {
        if(n == 0){
            return -1;
        }
        int index = 0;
        int[] nums = new int[n+1];
        for(int i = 1; i < n; i++){
            nums[i] = i;
        }
        recurse(nums, 1);
        return count;
    }
    
    private void recurse(int[] nums, int index){

        //base 
        if(index == nums.length){
            count++;
            return;
        }

        for(int i = index; i < nums.length; i++){
            if(nums[i] % i == 0 || i % nums[i] == 0){
                swap(nums, index, i);
                recurse(nums, i + 1);
                //backtrack
                swap(nums,index,i);

            }

            }
        }
        private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
}