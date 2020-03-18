class Solution {
    int result;
    public int countArrangement(int N) {
        if(N == 0) return 0;
        result = 0;
        backtrack(N, 1, new int[N+1]);          // visited array to keep track of whether the element is already processed or not
        return result;
    }
    
    private void backtrack(int N, int curr, int[] visited) {
        if( curr > N) {
            result++;
            return;
        }
        for(int i = 1; i <= N; i++) {       // visited array prevents repetitions in the same arrangement 
            if(visited[i] == 0 && (i%curr == 0 || curr%i == 0)) {   //if not visited and one of the conditions is satisfied, backtrack with updated curr
                visited[i] = 1;
                backtrack(N, curr+1, visited);
                visited[i] = 0;
            }
        }
    }
}

/*
solution = {}
backtrack(state):
  if state is goal:
    solution.add(state)
  for all candidates:
    if candidate is valid:
      state.add(candidate)
      backtrack(state)
      state.remove(candidate)
*/