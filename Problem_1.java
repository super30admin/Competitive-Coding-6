//Time Complexity: O(n!)
//Space Complexity: O(n!)
class Solution {
    int count=0;
    public int countArrangement(int n) {
        
        boolean[] used = new boolean[n+1];
        helper(n,1,used);
        return count;
    }
    private void helper(int n, int pos, boolean[] used){
        if(pos==n+1 ) {
            count++;
            return;
        }
        for(int i=1; i<=n; i++){
            if(used[i]==false && (pos%i==0 || i%pos==0)){
                used[i]=true;
                helper(n,pos+1,used);
                used[i]=false;
            } 
        }
    }
}