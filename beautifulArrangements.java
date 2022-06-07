// Time Complexity : O(k) - k=valid permutations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :YEs
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    int result;
    public int countArrangement(int n) {
        result = 0;
        int[] prem = new int[n+1];
        helper(prem, n, 1);
        return result;
    }
    
    private void helper(int[] prem, int n, int val){
        //base
        if(val>n){
            for(int i=1;i<prem.length;i++){
                System.out.println(prem[i]);
            }
            result++;
            return;
        }
        //logic
        for(int i=1;i<=n;i++){
            if(prem[i]==0){
                if(val%i==0 || i%val==0){
                    prem[i]=val;
                    helper(prem, n, val+1);
                    prem[i]=0;
                    
                }
            }
        }
    }
}