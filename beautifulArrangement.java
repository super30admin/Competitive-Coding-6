// Time Complexity : O(k), k is number of valid permutations.
// Space Complexity : O(n), n is number of elements.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * 1. Maintain a visited array to keep track of visited elements.
 * 2. For each element, check if it is divisible by level or level is divisible by element.
 * 3. If yes, add it to list and mark it as visited.
 * 4. Call helper recursively with level+1.
 * 5. Backtrack by removing element from list and marking it as unvisited.
 * 6. Return when list size is equal to n.
 */


import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        int[] count = new int[]{0};
        helper(n, 1, new ArrayList<>(), visited, count);
        return count[0];
    }

    private void helper(int n, int level, List<Integer> list, boolean[] visited, int[] count){
        if(list.size() == n){
            count[0]++;
            return;
        }

        for(int i=1; i<=n; i++){
            if(visited[i])
                continue;

            if(i % level != 0 && level % i != 0)
                continue;

            list.add(i);
            visited[i] = true;
            helper(n, level+1, list, visited, count);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}