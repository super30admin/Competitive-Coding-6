// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> state = new ArrayList<>();
        
        HashSet<Integer> set = new HashSet<>();
        
        backtrack(result, state, nums, set);
        
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> state, int[] nums, HashSet<Integer> set)
    {
        //System.out.println(state);
        if(state.size() == nums.length)
        {
            result.add(new ArrayList<>(state));
            return;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(!set.contains(nums[i])){
            set.add(nums[i]);
            state.add(nums[i]);
            backtrack(result, state, nums, set);
            state.remove(state.size()-1);
            set.remove(nums[i]);
            }
        }
    }
}
