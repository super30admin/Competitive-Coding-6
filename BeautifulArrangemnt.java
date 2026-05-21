
// Time Complexity : O(N!)
// Space Complexity :  o(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/**
 * 
 * The function uses a backtracking approach to explore all possible arrangements. It maintains a boolean array to keep track of which numbers have been used in the current arrangement. The helper function recursively builds the arrangement by checking each number for the current position and marking it as used if it satisfies the divisibility condition. When a valid arrangement is formed (when the position exceeds n), the count is incremented.
 */
class Solution {
    int count = 0;
  boolean[] array;
    public int countArrangement(int n) {
       array = new boolean[n+1];
        helper(n, 1);
        return count;
    }
     public void helper(int n, int s){

        if( s> n){
            count = count +1;
            return;
        }

        for(int i = 1; i <=n; i++){
              if (!array[i] && (i % s == 0 || s % i == 0)) {
                array[i] = true;
                helper(n, s + 1);
                array[i] = false;
            }
        }



     }
}