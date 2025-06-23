// Time Complexity : a little less than O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach :
/*
We are planning to create a boolean array rather than creating each path to save space and time.
While we create a new path via boolean array -  we check given condition
if we reach till the end of the number - we do count++
Using backtracking, we are re-using boolean array
 */

public class BeautifulArrangement {
        private int count;

        public int countArrangement(int n) {
            count = 0;
            if (n == 0) {
                return count;
            }

            helper(n, new boolean[n + 1], 1);              // (3, [4] )

            return count;
        }

        private void helper(int n, boolean[] visited, int idx) {
            // base
            if (idx > n) {
                count++;
                return;
            }
            //logic
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && ((i % idx) == 0 || (idx % i) == 0)) {
                    //action
                    visited[i] = true;
                    //backtrack
                    helper(n, visited, idx + 1);
                    //recurse
                    visited[i] = false;
                }
            }
        }
    }
