
// Time Complexity : n!
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
  int result =0;
    public int countArrangement(int n) {
      
      int[] nums = new int[n+1];
      
      backtrack(nums,n,1);
      return result;
        
    }
  
  private void backtrack(int[] nums,int n,int val)
  {
    //base case
    if(val > n)
    {
      result++;
      return;
    }
    
    //logic
    for(int i=1;i<=n;i++)
    {
      if(nums[i]==0 && (i%val == 0 || val%i == 0))
      {
        nums[i]=val;
        backtrack(nums,n,val+1);
        nums[i]=0;
      }
    }
    return;
  }
}