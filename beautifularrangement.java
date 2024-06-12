// TC : O(n!)
// SC : O(n)

class Solution {
    int count;
    public int countArrangement(int n) {
        count = 0;
        boolean[] isvisited = new boolean[n+1];
        helper(n,isvisited,1);
        return count;
    }
    private void helper(int n, boolean[] isvisited, int index){
        
        if(index>n){
            count++;
            return;
        }
        
        for(int i=1;i<=n;i++){
            if(!isvisited[i] && (i%index == 0 || index%i==0)){
                isvisited[i] = true;
                
                helper(n, isvisited, index+1);
                
                isvisited[i] = false;
            }
        }
    }
}