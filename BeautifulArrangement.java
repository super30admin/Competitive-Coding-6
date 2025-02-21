class Solution {
    //Time Complexity:O(2^n)
    //Space Compleixty:O(n)
       int count = 0; 
    public int countArrangement(int n) {
       int index = 1;
       boolean[] visited = new boolean[n+1];
        backtrack (n, index, visited);
        return count;
    }
    private void backtrack (int n, int index, boolean[] visited){
        if (index>=visited.length){
            count++;
            return;
        }

        for (int i =1;i <=n; i++){
            if (!visited[i] && (index% i== 0 || i%index ==0)){
                visited[i] =true;
                backtrack (n, index+1, visited);
                visited[i] =false;
            }
        }
    }
}
