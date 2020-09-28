    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/permutations/
    Time Complexity for operators : o(n!) .. n is the length of the string
    Extra Space Complexity for operators : o(n) n = number of elements in the array
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. Backtracking
                    A) Call the backtracking function from main fucntion with initial values.
                    B) The backtracking function will contains input as nums array, hashset to maintain visited and output.
                    C) Base case, path.size == nums.length() then add path into final output.
                    F) In the main backtracking for loop, check if it is element is already visited in hashset.
                    E) then do backtracking, call backtracking function by pass all variables.
                    F) At the end, remove last element from the list and hashset  also.
                    G) In main function, return final output.

    */  

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>(); 
        
        backtracking(nums,new ArrayList<>(),new HashSet<>(),output);
        
        return output;
    }
    
    private void backtracking(int[] nums, List<Integer> path, HashSet<Integer> hashSet,List<List<Integer>> output){
        
        // base
        if(path.size() == nums.length){
            output.add(new ArrayList<>(path));
            return;
        }
        
        // backtracking
        for(int i=0;i<nums.length;i++){
            // check hashset
            if(!hashSet.contains(nums[i])){
                hashSet.add(nums[i]);
                path.add(nums[i]);
                
                backtracking(nums,path,hashSet,output);
                hashSet.remove(nums[i]);
                path.remove(path.size()-1);
            }
        }
    }
}