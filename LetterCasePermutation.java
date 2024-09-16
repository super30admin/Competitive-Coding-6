/**
 * Space Complexity: O(N)?
 * Time Complexity: O(2^N)
 * Leetcode: Runs successfully
 */
class Solution {
    private List<String> solution;
   
   public List<String> letterCasePermutation(String S) {
       //initialize solution list
       solution = new ArrayList<>();
       
       //call helper function to populate results
       getPermutations(S, 0, "");
       
       //return result
       return solution;
   }
   
   
   private void getPermutations(String s, int index, String current){
       // base case
       if(current.length() == s.length()){
           solution.add(new String(current));
           return;
       }
       //iterate through string
       for(int i = index; i < s.length(); i++){
           char c = s.charAt(i);
           if(Character.isDigit(c)){
               current += c;
               getPermutations(s, i + 1, current);
               current = current.substring(0, current.length() - 1);
           }
           else {
               // call uppercase
               current += Character.toUpperCase(c);
               getPermutations(s, i + 1, current);
               current = current.substring(0, current.length() - 1);
               //call lowercase
               current += Character.toLowerCase(c);
               getPermutations(s, i + 1, current);
               current = current.substring(0, current.length() - 1);
           }
       }
   }
   
}