
// Time Complexity : O(k), where k<N! , since we only proceed with valid permutations in backtracking
// Space Complexity : O(N), recursion stack space, used[] bool array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : had difficulty building intuition on filling places

// Your code here along with comments explaining your approach
// Attempt is to generate all permutations, at the end check if permutation is valid
// optimization could be to stop proceeding in cases where current permute is invalid, backtracking
// try to fill each place with values from 1 to N, if already filled donot use the number again
// check pos%i==0 || i%pos==0


class Solution {
    int count;
    int N;
    boolean[] used; 
    
    public int countArrangement(int N) {
        this.used = new boolean[N+1];
        this.N = N;
        
        int place = 1;
        helper(place);
        return count;
    }
    
    private void helper(int place){
        if(place==N+1){
            count++;
            return;
        }
        
        for(int i=1; i<=N; i++){
            if(!used[i] && (place%i==0 || i%place==0)){
                used[i] = true;
                helper(place+1);
                used[i] = false;
            }
        }
        
    }
}