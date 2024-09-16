package S30.CompetitiveCoding_6;

/*
Time Complexity : O(N!) - Generate every permutation in worst case - if all are valid
Space Complexity : O(N) - space used by recursive stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class BeautifulArrangement {

    int count;
    public int countArrangement(int N) {
        this.count = 0;
        boolean[] visited = new boolean[N+1];
        backtrack(N,1,visited);
        return count;
    }

    private void backtrack(int N , int index, boolean[] visited){
        //base
        if(index == N+1){
            count++;
            return;
        }

        //logic
        for(int i = 1; i <= N; i++){

            if(visited[i]) continue;
            if(i % index == 0 || index % i == 0){
                visited[i] = true;
                backtrack(N,index+1,visited);
                visited[i] = false;
            }
        }
    }
}
