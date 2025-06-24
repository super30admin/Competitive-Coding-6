/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity - O(K).k - K is Valid permutations
Space complexity - O(N) recursive stack
 */

public class BeautifulArrangement_LC_526 {
    int count = 0;
    public int countArrangement(int n) {
        int[] nums = new int[n];

        for(int i =1; i<=n; i++) {
            nums[i-1] = i;
        }
        //generate the combinations
        generateCombinations(nums, 0);
        return count;
    }

    private void generateCombinations(int[] nums, int l) {
        //base case
        if(l == nums.length){
            count++;
        }
        for(int i = l; i< nums.length; i++){
            swap(nums, i, l);
            //choose but check the index divisible condition
            if(nums[l] % (l+1) == 0 || (l+1) % nums[l] ==0)

                generateCombinations(nums, l+1);
            //unchoose
            swap(nums, i, l);

        }
    }
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
