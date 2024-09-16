// time - O(k) - number of valid permutations - worst case n! if all permutations are valid
//space - O(n) - depth of call stack

class Solution {
    int result;
    public int countArrangement(int N) {
        if(N <= 0) return 0;
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

<----Using HashSet--->

class Solution {
    public int countArrangement(int N) {
        List<Set<Integer>> result = new ArrayList<>();
        
        if(N <= 0) return 0;
        
        Set<Integer> visited = new HashSet<>();
        backtrack(N, visited, result);
        return result.size();
    }

    private void backtrack(int N, Set<Integer> visited, List<Set<Integer>> result) {
        
        if(visited.size() == N) {
            result.add(new HashSet<>(visited));
            return;
        }
       
        for(int i = 1; i <= N; i++) {
            if(!visited.contains(i)) 
            {
                int position = visited.size() + 1;
                if(i % position == 0 || position % i == 0){ 
                    visited.add(i); 
                    backtrack(N, visited, result); 
                    visited.remove(i); 
                }
            }
        }
    }
}



