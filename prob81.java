// 784. Letter Case Permutation
// S30 Big N Problem #81 {Easy}
// Space complexity:exponential; O(2^n) where n is the string length (recursive stack)
// Time complexity:exponential; O(2^n) where n is the string length
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result=new ArrayList<>();
        char [] carray=S.toCharArray();
        backtrack(0,carray,result);
        return result;
    }
    
    private void backtrack(int index, char [] carray, List<String> result){
        if(index==carray.length){
            result.add(String.valueOf(carray));
        }else if(!Character.isLetter(carray[index])){
            backtrack(index+1,carray,result);
        }else{
            backtrack(index+1,carray,result);
            if(Character.isLowerCase(carray[index])){
                carray[index]=Character.toUpperCase(carray[index]);
                backtrack(index+1,carray,result);
                carray[index]=Character.toLowerCase(carray[index]);
            }
            else{
                carray[index]=Character.toLowerCase(carray[index]);
                backtrack(index+1,carray,result);
                carray[index]=Character.toUpperCase(carray[index]);
            }
        }
    }
}