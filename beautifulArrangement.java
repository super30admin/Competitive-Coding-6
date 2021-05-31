//Time complexity O(npown)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : yes

// while thinking the logic, I missed taking the point on how will I be keeping the track of element I have taken previously for which I used position now and to not visit the index already visited, I am taking a visited boolean to keep a track of it. Using backtracking and recursion, the problem can be solved.
class Solution {
    int result;
    public int countArrangement(int n) {
        
     result = 0;
        
        if(n == 0){
            
            return result;
        }
        
        int position = n;
        backtrack(n, position, new boolean[n + 1]);
        
        return result;
        
    }
    
    private void backtrack(int N, int position, boolean[] visited){
        
        if(position == 0){
            
            result++;
            return;
        }
        
        for(int i = 1; i <= N; i ++ ){
            
            //int index = i;
          if(visited[i] == false && (i % position == 0 || position % i == 0)){
              
            visited[i] = true;
            backtrack(N, position - 1, visited);
            visited[i] = false;
              
          }
            
        }
    }
}