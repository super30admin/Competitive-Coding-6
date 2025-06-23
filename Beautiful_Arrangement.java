/*
 * TC: O(n), n: no. of valid permutation.
 * SC: O(n), n: size of visited[] and depth of recursive stack.
 * 
 * Approach: Try to create all possible permutation from a given number.Also while creating the permutation if it doesnt satisfy the beautiful rules given then , i dont compute further permutation for that positons.
 * each time a number stisfy the rules, i update my visited[] for this number as true and recurse.at last, backtrack and update my visited[] to false;
 */

class Solution {
    int result=0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        helper(1, n , visited);
        return result;
    }
    private void helper(int idx, int n, boolean[] visited){
        //base
        if(idx > n){
            result++;
            return;
        }
        //logic
        for(int i =1; i<= n; i++){
        if(!visited[i] && (idx%i == 0 || i%idx == 0)){
            visited[i] = true;
            //recurse
            helper(idx+1, n, visited);
            //backtrack
            visited[i] = false;
        }
        }
    }
}