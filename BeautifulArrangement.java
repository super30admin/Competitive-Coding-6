package CompetitiveCoding6;

import java.util.ArrayList;

public class BeautifulArrangement {
    int[] visited;
    int count;
    public int countArrangement(int n) {
        visited = new int[n];
        backtrack(n, new ArrayList<>());
        return count;
    }
    private void backtrack(int n, ArrayList<Integer> path){
        //base
        if(path.size() == n){
            System.out.println(path);
            count++;
        }
        //logic
        for(int i=0; i<n;i++){
            if(visited[i] == 0){
                path.add(i+1);
                if((path.size() % (i+1)) == 0 || ((i+1) % path.size()) == 0)
                {
                    visited[i] = 1;
                    backtrack(n, path);
                    visited[i] = 0;
                }
                path.remove(path.size()-1);
            }
        }

    }
}
