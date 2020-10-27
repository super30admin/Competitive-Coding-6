// Time Complexity : O(N^N)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, 657ms
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    int count;
    public int countArrangement(int N) {
        
        int[] nums = new int[N];
        
        for(int i = 1; i <= N; i++){
            nums[i-1] = i;
        }
        
        List<Integer> list = new ArrayList<>();
        
        helper(nums, list);
        
        return count;

    }
    
    private void helper(int[] nums, List<Integer> list){
        
        if(nums.length == list.size()){
            count++;
            return;
        }
        
        for(int i = 0; i < nums.length; i++){

        if(list.contains(nums[i])){
            continue;
        }
        if(nums[i] % (list.size() + 1) == 0 || (list.size() + 1)%nums[i] == 0){
            list.add(nums[i]);
            helper(nums, list);
            list.remove(list.size() -1);
        }
            
        }

    }
}

