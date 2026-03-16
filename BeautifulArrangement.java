// Time Complexity : O(k), k = number of valid permutations, in worst case, it could go upto O(n!)
// Space Complexity : O(n) (for recursion stack and visited array)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to iterate from 1 to n numbers by checking we are not visiting the same number again and also
keeping track of the position. When we exceed the position value more than input n, we increment the count
marking we received a beautiful arrangement.To avoid processing of inapplicable permutations, we prune early
by checking the position and i are divisible by each other or not. If either of them is divisible, we go with
the recursion, if we not we backtrack the visited element.
 */
class Solution {
    int count;
    public int countArrangement(int n) {
        this.count = 0;
        helper(n, 1, new boolean[n + 1]);
        return count;
    }

    private void helper(int n, int pos, boolean[] visited) {
        if(pos > n) {
            count++;
            return;
        }

        for(int i = 1 ; i <= n ; i++) {
            if(!visited[i] && (pos % i == 0 || i % pos == 0)) {
                //action
                visited[i] = true;
                //recurse
                helper(n, pos + 1, visited);
                //backtrack
                visited[i] = false;
            }
        }
    }
}