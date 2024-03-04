public class Beautiful_Arrangement {
    //TC: O(n!)
    //SC: O(n)
    int count=0;
    public int countArrangement(int n) {
        int[] nums = new int[n+1];
        for(int i=1; i<=n; i++){
            nums[i] = i;
        }
        helper(nums, 1);
        return count;
    }
    void helper(int[] nums, int idx){
        if(idx==nums.length){ //action
            count++;
            return;
        }
        for(int i=idx; i<nums.length; i++){
            if(nums[i]%idx==0 || idx%nums[i]==0){
                swap(nums, idx, i);
                helper(nums, idx+1); //recurse
                swap(nums, i, idx); //re-do
            }
        }
    }
    void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
