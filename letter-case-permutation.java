// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        
        backtrack(result, S, 0);
        
        return result;
    }
    private void backtrack(List<String> result, String word, int start)
    {
        System.out.println(word);
        result.add(word);
        
        for (int i=start; i<word.length(); i++)
        {
            char[] wordArray = word.toCharArray();
            if(Character.isLetter(word.charAt(i)))
            {
                if(Character.isUpperCase(word.charAt(i)))
                {
                wordArray[i]=Character.toLowerCase(word.charAt(i));
                backtrack(result, String.valueOf(wordArray), i+1);
                } else {
                  wordArray[i]=Character.toUpperCase(word.charAt(i));
                backtrack(result, String.valueOf(wordArray), i+1);  
                }
            } else {
                continue;
            }
        }
    }
}
