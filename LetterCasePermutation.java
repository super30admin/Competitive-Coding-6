// Time Complexity : O(n)
// Space Complexity : O(n) Recursion Stack Space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
	class Solution {
	    public List<String> letterCasePermutation(String S) {
	        List<String> list = new ArrayList<>();
	        if(S == null || S.length() == 0){
	            list.add("");
	            return list;
	        }
	        List<String> result = letterCasePermutation(S.substring(1));
	        for(String s: result){
	            char c = S.charAt(0);
	            if(Character.isLetter(c)){
	                list.add(Character.toUpperCase(c) + s);
	                list.add(Character.toLowerCase(c) + s);
	            } else {
	                list.add(c + s);
	            }
	        }
	        return list;
	    }
	}
}
