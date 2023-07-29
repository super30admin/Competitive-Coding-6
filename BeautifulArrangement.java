// Time Complexity : n! because as we go through levels we have n * n-1 * n-2...1 choices
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
import java.util.HashSet;
public class BeautifulArrangement {
    private int result;
    private HashSet<Integer> visited;
    public int countArrangement(int n) {
        this.visited = new HashSet<>();
        findPermutations(n, 1);
        return result;
    }

    private void findPermutations(int n, int current){
        //base
        if( visited.size() % current !=0 && current %  visited.size() != 0){
            return;
        }
        if(visited.size() == n){
            result++;
            return;
        }

        for(int i = 1; i <= n; i++){
            if(!visited.contains(i)){
                visited.add(i);
                findPermutations(n, i);
                visited.remove(i);
            }
        }
    }
}
