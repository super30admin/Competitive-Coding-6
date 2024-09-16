// Time Complexity : O(N!)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    int count;
    public int countArrangement(int N) {
        
        if(N == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        helper(N, 1, set);
        return count;
        
    }
    private void helper(int N, int pos, HashSet<Integer> set) {
        
        if(pos > N) {
            count++;
            return;
        }
        
        for(int i = 1; i <= N; i++) {
            if(!set.contains(i) && ((i % pos == 0)||(pos % i == 0))) {
                set.add(i);
                helper(N, pos + 1, set);
                set.remove(i);
            }
        }
    }
}