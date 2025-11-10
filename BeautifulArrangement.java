// 526. Beautiful Arrangement
// https://leetcode.com/problems/beautiful-arrangement/description/


/**
 * Time Complexity: O(n * n!)
 * Space Complexity: O(n) 
 */

/**
 * Approach: We start our permutation by iterating over n elements for each position
 * For each element, we first check if it's already present in our permutation list, if yes we move to next element
 * If unvisited element, we check if it satisfies conditions of Beautiful Arrangement i.e (i % pos == 0) || (pos % i == 0)
 * if condition is satisfied, we move to next position by recursion
 * When position reaches out of bounds, means we found our permutation so increase count
 */

class Solution {
    int count;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        count = 0;

        helper(n, visited, 1);

        return count;
    }

    private void helper(int n, boolean[] visited, int pos){
        // base condition
        if(pos > n){
            count++;
            return;
        }

        // logic

        for(int i = 1 ; i <= n ; i++){

            if(visited[i] == true){
                continue;
            }

            if(i % pos == 0 || pos % i == 0){
                visited[i] = true;
                helper(n, visited, pos + 1);
                visited[i] = false;
            }
        }

    }
}