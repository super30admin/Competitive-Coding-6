class Solution {
    int cnt=0;
    boolean visited[];
    public int countArrangement(int n) {
        this.visited=new boolean[n+1];
        helper(n,1);
        return cnt;
    }
    public void helper(int n,int pivot){
        if(pivot>n){
            cnt++;
            return;
        }
        for(int i=1;i<=n;i++){
            if(!visited[i] && (pivot%i==0||i%pivot==0)){
                visited[i]=true;
                helper(n,pivot+1);
                visited[i]=false;
            }
        }
    }
}
