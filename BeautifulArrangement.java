/**
 * Time: Exponential -O(n^n)
 * Space: O(n) stk space and set size
 */
class Solution {
    int count;
    int n;
    public int countArrangement(int N) {
        n = N;
        Set<Integer> set = new TreeSet<>();
        helper(set);
        return count;
    }
    private void helper(Set<Integer> set){
        //base
        if(set.size() == n){
            count++;
            return;
        }
        //case
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                int idx = set.size()+1;
                if(i%idx==0 || idx%i == 0){
                    set.add(i);
                    helper(set);
                    set.remove(i);
                }else continue;
            }
        }
    }

}