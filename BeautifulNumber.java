// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;

public class BeautifulNumber {
    int count;
    public int countArrangement(int N) {
        count = 0;
        backtrack(N,new ArrayList<>());
        return count;
    }

    private void backtrack(int N, ArrayList<Integer> temp){
        if(temp.size() == N){
            count++;
            return;
        }

        for(int i = 1; i <= N; i++){
            if(temp.contains(i)){
                continue;
            }

            if((temp.size()+1) % i == 0 || i % (temp.size()+1) == 0){
                temp.add(i);
                backtrack(N,temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
