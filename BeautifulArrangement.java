/* Time Complexity :  O(k) where k is no of beautiful arrangements
   Space Complexity :  O(n)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    boolean[] visited;
    int c;
    public int countArrangement(int n) {
        visited = new boolean[n+1];
        helper(n,1);
        return c;
    }
    private void helper(int n,int index){
        //base
        if(index>n){
            c++;
            return;
        }
        //logic
        for(int i=1;i<=n;i++){
            if(visited[i]==true)
                continue;
            if(i%index==0 || index%i==0) //check beautiful arrangement for this element
            {
                visited[i]=true;
                helper(n,index+1);
                visited[i]=false;
            }
        }
    }  
}