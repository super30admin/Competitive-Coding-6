//Time Complexity : O(k), k -> number of permutations
//Space Complexity : O(n)
class Solution {
    private int count = 0;
    public int countArrangement(int n) { 
        boolean [] visited = new boolean[n+1];
        backtrack(n,1,visited);
        return count;
    }
    private void backtrack(int n, int index, boolean visited[]){
        //base
        if(index > n)
            count++;
        //logic
        for(int i = 1 ; i <= n; i++){
            if(!visited[i] && (index % i== 0 || i % index ==0)){
            //action
            visited[i]=true;
            //recurse
            backtrack(n,index+1,visited);
            //backtrack
            visited[i]=false;
            }
        }
    }
}
