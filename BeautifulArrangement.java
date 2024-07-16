// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
  int count;
  public int countArrangement(int n) {
    if(n == 0) return 0;
    count = 0;
    backtrack(n, 1, new boolean[n+1]);
    return count;
  }

  void backtrack(int n, int pos, boolean[] used) {
    // Base
    if(pos > n) {
      count++;
      return;
    }
    // Logic
    for(int i = 1; i<=n; i++) {
      if(!used[i] && (i%pos==0 || pos%i==0)){
        // Action
        used[i] = true;
        // Recurse
        backtrack(n, pos+1, used);
        // Backtrack
        used[i] = false;
      }

    }
  }
}
