import java.util.*;

public class BeautifulArrangement {
    /*

    TC: O(n!)
    SC: O(n)

    */
    int count;
    public int countArrangement(int n) {
        if(n==0) return count;
        backtrack(n,1,new ArrayList<>());
        return count;
    }

    public void backtrack(int n,int index,List<Integer> path){
        if(index==n+1){
            count++;
            return;
        }

        for(int i=1;i<=n;i++){
            if(path.contains(i)) continue;
            if(index%i==0 || i%index==0){
                path.add(i);
                backtrack(n,index+1,path);
                path.remove(path.size()-1);
            }
        }
    }
}