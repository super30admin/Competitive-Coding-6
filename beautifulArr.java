//Time: O(N^n), where N is the length of the input
//Space: O(1)
public class beautifulArr {
    int counter = 0;
    public int countArrangement(int n) {
       boolean [] visited = new boolean[n + 1];
        calcValidPos(n, 1, visited);
        return counter;
    }
    
    private void calcValidPos(int n, int position, boolean[] visited) {
        //base
        if (position > n)
            counter++;
        for(int i = 1; i <= n; i++) {
            if(!visited[i] && (position % i == 0 || i % position == 0)){
                //action
                visited[i] = true;
                calcValidPos(n, position + 1, visited);
                //undo action
                visited[i] = false;
                
            }
                
        }
    }
}
