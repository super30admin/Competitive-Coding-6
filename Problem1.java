//TC: O(n!)
//SC: O(n)
class Solution {
    HashSet<Integer> set;
    private int backtrack(List<Integer> path, int n,int pivot){
        //base
        if(pivot >= n)
            return 1;
        int ans = 0;
        for(int i = 1; i <= n; i++){
            int idx = path.size()+1;
            if(!set.contains(i) && ( (idx%i)==0 || (i%idx)==0)){
                
            path.add(i);
            set.add(i);
            ans += backtrack(path,n,pivot+1);
            path.remove(path.size()-1);
            set.remove(i);}
            
        }
        return ans;
    }
    public int countArrangement(int n) {
        this.set = new HashSet<>();
        int res = backtrack(new ArrayList<>(),n,0);
        return res;
    }
}