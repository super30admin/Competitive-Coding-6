

// Time Complexity : O(2^N ∗ N)
// Space Complexity : O(2^N ∗ N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        if(S.isEmpty() || S == null)
            return list;
        backtrack(S.toCharArray(),0,list);
        return list;
    }
    
    public void backtrack(char chars[],int index,List<String> list ){
        if(index == chars.length){
            list.add(new String(chars));
            return;
        }
        else {
            if(Character.isLetter(chars[index])){
                    chars[index] = Character.toUpperCase(chars[index]);
                    backtrack(chars,index + 1,list);
                    chars[index] = Character.toLowerCase(chars[index]);
            }
                backtrack(chars,index + 1,list);
        }
    }
}