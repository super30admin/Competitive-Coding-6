
// Time Complexity :O(n!)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    int result = 0;
    public int countArrangement(int n) {
      
      int[] nums = new int[n+1];
      backtrack(n,nums,1);
      return result;
        
    }
  
    private void backtrack(int n,int[] nums, int val)
    {
      //base case
      if(val>n)
      {
      	//increment the result when all values from 1-n have been filled in the array
        result++;
        return;
      }
      
      
      //logic , not considering the 0th index at any point as perm is 1-indexed
      for(int i=1;i<=n;i++)
      {
      	//if the current index is not used and the current elemnt satisifies any of the condition
        if(nums[i]==0 &&(val%i==0 || i%val==0))
        {
          nums[i]=val;
          //recursion
          backtrack(n,nums,val+1);
          //backtrack
          nums[i]=0;
        }
      }
    }
}
