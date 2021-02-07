/**

Time Complexity : O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution
{
    int count;
    public int countArrangement(int n)
    {
        this.count = 0;
        int nums[] = new int[n+1];
        for(int i=1;i <=n; i++)
            nums[i] = i;
        helper(nums, 1);
        return this.count;
    }
    // -1, 1,  2, 3
    private void helper(int nums[], int index)
    {
        if(index == nums.length)
        {
            count++;
            return;
        }
            for( int i = index; i < nums.length; i++)
            {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                if(nums[index] % index == 0 || index % nums[index] == 0)
                    helper(nums, index + 1);
                temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
    }
}