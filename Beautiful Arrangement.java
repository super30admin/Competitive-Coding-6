//  Time Complexity: O(n!)
//  Space Complexity: O(n)
class Solution {

    int count;
    boolean visited[];
    public int countArrangement(int n) {
        this.visited = new boolean[n];
        this.count = 0;

        helper(n, new ArrayList<>());
        return count;
        
    }

    private void helper(int n, List<Integer> path){
        // base
        if(path.size() == n){
            
            count++;
            return;
        }

        // logic

        for(int i=0; i<n; i++){
            if(!visited[i]){
                if((path.size() +1)%(i+1) == 0 || (i+1)%(path.size()+1) == 0){
                    // action
                    visited[i] = true;
                    path.add(i+1);

                    // recursive
                    helper(n, path);

                    // backtrack
                    path.remove(path.size()-1);
                    visited[i] = false;
                }
            }
        }
    }
}