//Time Complexity: O(n!)
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem1 {

    boolean[] visited;
    int count;
    public int countArrangement(int n) {
        
        visited = new boolean[n+1];
        helper(n, 1);
        return count;
    }
    
    private void helper(int n, int index){
        
        if(index == n+1)
            count += 1;
        
        for(int i =1; i <=n; i++){
            
            if(visited[i] == true)
                continue;
            
            if(index%i ==0 || i%index==0)
            {
                visited[i] = true;
                helper(n, index +1);
                visited[i] = false;
            }
        }
    }
}
