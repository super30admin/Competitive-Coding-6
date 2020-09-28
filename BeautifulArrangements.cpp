// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    
    int result = 0;
 
    int countArrangement(int N) {
        vector<int> V(N+1);
        
        helper_backtracking(N,V,1);
    return result;
        
    }
    
    void helper_backtracking(int N, vector<int> &V, int position){
        
        if(position > N){
            result ++;
            return;
        }
        
        for ( int i= 1; i <= N; i ++){
            
            if((i % position == 0 || position % i == 0) && (V[i] == 0)){
                
                V[i] = 1;
                
                helper_backtracking(N, V, position +1);
                
                V[i] = 0;   // backtracking
            
        }
        }
    }
};