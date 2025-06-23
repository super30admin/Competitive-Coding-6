
class Solution {
    int count = 0;
    public int countArrangement(int n) {
        helper(new int[n], new HashSet<>(), n, 0);
        return count;
    }

    private void helper(int[] list, HashSet<Integer> set, int n, int end){
        // Base case
        if(isBeautyful(list, end)){
            if(end == n){
                count++;
                return;
            }
        }else return;
        // logic 
        for(int i = 1; i <= n; i++){
            if(!set.contains(i)){
                // action
                list[end] = i;
                set.add(i);
                // recurse
                helper(list, set, n, end+1);
                // backtrack
                set.remove(i);
            }
        }
    }

    private boolean isBeautyful(int[] list, int end){
        for(int i = 1; i <= end; i++){
            if(list[i-1] % i != 0 && i % list[i-1] != 0) return false;
        }
        return true;
    }
}
