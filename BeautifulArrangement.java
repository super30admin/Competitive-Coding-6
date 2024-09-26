// Time Complexity : O(k) Checks all valid permutations
// Space Complexity : O(n) A temprary list to store the valid permutation
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Used backtracking to form the permuation of array of n numbers
// The validity of the permuation is checked before backtracking and recursing to avoid traversing through all possible permutations 

class Solution {
    int count =0;
    public int countArrangement(int n) {
        backtrack(n, new ArrayList<>(),1);
        return count;
    }
    
    public void backtrack(int n, List<Integer> list,int i){
        if(list.size() == n){
            count++;
        }
        for(int j=1;j<=n;j++){
            if(!list.contains(j) && (i%j == 0 || j%i == 0)){
                list.add(j);
                backtrack(n,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
