import java.util.*;
//Time Complexity : O(n!), no of valid permutations
//Space Complexity : O(n), depth of recursive call stack
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

public class Permutations {
	List<List<Integer>> result;

	public List<List<Integer>> permute(int[] nums) {
		result = new ArrayList<>();
		if(nums == null || nums.length == 0)
			return result;
		backtrack(nums, new ArrayList<>());
		return result;
	}
	private void backtrack(int[] nums, List<Integer> temp){
		//base
		if(temp.size() == nums.length ){
			result.add(new ArrayList<>(temp));
			return;
		}

		//logic
		for(int i=0; i<nums.length; i++){
			if(temp.contains(nums[i]))
				continue;

			//action
			temp.add(nums[i]);
			//recurse
			backtrack(nums, temp);
			//backtrack
			temp.remove(temp.size()-1);
		}
	}
}
