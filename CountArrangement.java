
// Time Complexity : The time complexity is exponential
// Space Complexity : The space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {

    boolean[] visited;
    int count;

    public int countArrangement(int n) {

        if(n == 1){
            return 1;
        }

        visited = new boolean[n+1];
        recursion(n,1);
        return count;

    }

    public void recursion(int n,int index){

        if(index == n+1){
            count++;
        }

        // Iterate from 1 to n to choose whether to take the number for permutations or not
        for(int i=1;i<=n;i++){
            if(!visited[i] && (i%index == 0 || index%i == 0)){
                visited[i] = true;
                recursion(n,index+1);
                visited[i] = false;
            }
        }
    }
}