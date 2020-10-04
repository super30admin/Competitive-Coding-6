
// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Backtracking
class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        if(n==0)
            return res;
        helper(n, 0, 0, new StringBuilder());
        return res;
    }
    
    private void helper(int n, int open, int close, StringBuilder sb){
        if(2*n == sb.length()){
            res.add(sb.toString());
        }
        
        if(open<n){
            helper(n, open+1, close, sb.append("("));
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            helper(n, open, close+1, sb.append(")"));
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
