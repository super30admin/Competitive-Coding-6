TC:O(2^n)
SC:O


63 / 63 test cases passed.
Status: Accepted
Runtime: 4 ms
Memory Usage: 41.4 MB


Approach: we go through each index and check whether it is a number or character, if it is a number we recurse to next index, if it is 
a character we first recurse with that index changed to lowercase in the same level, change the character to uppercase.We do that till the 
index become length of string.

class Solution {
    List<String> result ;
    public List<String> letterCasePermutation(String S) {
      result = new ArrayList<>();
        backtrack(S,0);
      return result;   
    }
    private void backtrack(String S,int index){
        
        if(index == S.length()) 
        { result.add(S);
            return;
        }
        if(Character.isDigit(S.charAt(index))){
            backtrack(S,index+1);}
        else{
            backtrack(S.substring(0,index)+Character.toLowerCase(S.charAt(index))+S.substring(index+1),index+1);
            backtrack(S.substring(0,index)+Character.toUpperCase(S.charAt(index))+S.substring(index+1),index+1);
                
        }
        }
        
    }
