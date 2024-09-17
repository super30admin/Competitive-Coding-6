//Time Complexity:O(N*2^N) as at each step, the output increses in powers of 2 and N since we'll be exploring the entire string.
//Space Complexity:O(N*2^N)
//In this problem, I'll be having a backtrack function that will find all the possible combinations of the given string. In the backtrack function, I'll be adding the string to the result list as and when the index becomes equals to the length of the string(character array). Else, if the encountered character is a letter, I'll be adding that to the target in the lowercase form and call the backtrack function for the next index. This will make the lowercase branch. Then I'll also be appending the upper case version of it and call the backtrack function for the next index. This will make the uppercase branch. If it is not a letter, I'll simply call the backtrack function for the next index.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public List<String> letterCasePermutation(String S) {
        
        List<String> res=new ArrayList<>();
        if(S.length()==0){
            return res;
        }
        backtrack(res,S.toCharArray(),0);
        return res;
    }
    //Function to construct all possible combinations of the string
    public void backtrack(List<String> res,char[] S, int index){
        if(index==S.length){
            res.add(new String(S));
            return;
        }
        if(Character.isLetter(S[index])){
            S[index]=Character.toLowerCase(S[index]);
            backtrack(res,S,index+1);//lowercase branch
            S[index]=Character.toUpperCase(S[index]);
            backtrack(res,S,index+1);//uppercase branch
        }
        else{
            backtrack(res,S,index+1);
        }
    }
}