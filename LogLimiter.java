
// Your code here along with comments explaining your approach
// Space - O(N) Time -  O(N!) where N! is the number of permutation
class Solution {
    boolean[] visited;
    List<Set<Integer>> res;
    public int countArrangement(int N) {
        //edge case
        if(N <= 0) return 0;
        
        visited = new boolean[N + 1];
        res = new ArrayList<>();
        backtrack(new HashSet<>(), 1, N);
        return res.size();  
    }
    
    private void backtrack(Set<Integer> temp, int position, int N){
        // base case
        if(position > N ){
            res.add(new HashSet<Integer>(temp));
            System.out.println(res);
            return;
        }
        
        //logic
        for(int i = 1; i <= N; i++){
            if(!temp.contains(i) && (i % position == 0 || position % i == 0)){
                //action
                
                temp.add(i);
                backtrack(temp, position + 1, N);
                
                temp.remove(temp.size() - 1);
            }
            
        }
        
    }
}