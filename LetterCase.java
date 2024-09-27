// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
	List<String> result = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
		if(S == null || S.length() == 0){		// base case
			return result;
		}
		
		backtrack(S, 0, "");		// call the DFS function recursively
        return result;
    }
	
	private void backtrack(String S, int index, String temp){
		// base case
		if(index == S.length()){			// base case
			result.add(temp);
			return;
		}
		// logic
		char c = S.charAt(index);		// get the char at the indec
		
        if(Character.isDigit(c)){		// if the char is digit, append it to the string and increment the index
            String temp3 = temp + c;
			backtrack(S, index + 1, temp3);
        }else{
            String temp1 = temp + Character.toLowerCase(c);	// if we encounter a letter, we need to make 2 choices, lowercase and uppercase and increment the index recursively
			backtrack(S, index + 1, temp1);
			String temp2 = temp +  Character.toUpperCase(c);
			backtrack(S, index + 1, temp2);
        }
	}
}