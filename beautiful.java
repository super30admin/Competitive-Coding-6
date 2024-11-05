class Solution {
    int count;
    public int countArrangement(int n) {
        
        helper(0,n, new HashSet<>());
        return count;
    }
    private void helper(int idx, int n, HashSet<Integer> path){
        if(idx==n){
            count++;
            return;
        }

        for(int i=1;i<=n;i++){
            if(path.contains(i)){
                continue;
            }
            if(i%(idx+1)==0 || (idx+1)%i==0){
                path.add(i);
                helper(idx+1,n,path);
                path.remove(i);
            }            
        }
    }
}
