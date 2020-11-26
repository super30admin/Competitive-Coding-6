package Nov25;

class BeautifulArrangement {
    
    /*
    Time Complexity: O(n!) 
    
    Space Complexity: Visited array=O(n) + Recursive Stack=O(n)
    
    Approach: Backtracking solution and visited array used to mark wherever some elements have been fixed for their positions during a FOR loop iteration.
    
    */
    
    int count;
    
    public int countArrangement(int N) {
        if (N == 0) {
			return 0;
        }
        backtrack(1, new int[N+1], N);
        return count;
    }
    
    // helper function for backtracking
    public void backtrack(int index,int[] visited, int N ){
        
     // base
     if(index > N){
        count++;
        return;
     }
            
   // logic     
    for (int i = 1; i <= N; i++) {
        if (visited[i] == 0 && ( i % index == 0 || index % i == 0)) {
                visited[i] = 1;
                backtrack(index+1,visited,N);
                visited[i] = 0;   
        }
    }
    }
    
}