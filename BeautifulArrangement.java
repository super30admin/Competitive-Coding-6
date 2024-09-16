/**
 * Time Complexity :O(n!) where n = number of valid permutations 
 * Space Complexity : O(n)
 */
import java.util.*;
public class BeautifulArrangement{
    Set<Integer> set;
    int count;
    public int countArrangement(int N) {
        set = new HashSet<>();
        count = 0;
        if(N<=0) return 0;
        recurse(set,N,1);
        return count;   
    }
    
    private void recurse(Set<Integer> visited,int n,int index){
        //base
        if((visited.size()%index)!=0 && (index%visited.size())!=0) return;
        if(visited.size() == n){
            count++;
            return;
        }
        
        //logic
        for(int i=1;i<=n;i++){
            if(!visited.contains(i)){
                //action
                visited.add(i);
                //recurse
                recurse(visited,n,i);
                //backtrack
                visited.remove(i);
            }
        }
        
    }
}