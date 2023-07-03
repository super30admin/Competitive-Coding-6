// Time Complexity - O(4*(4^(Total No of input letters corresponding to numbers in input string))) - as for loop based recursion -- 4 to the power bexacuse worst case we can have say 9999 -- so 4 letters for each number hence every letter for the top level for loop will have 4 choices and multiplied by 4 because the top level for loop iterates for 4 letters -- not sure
// Space Complexity - O(4*(4^(Total No of input letters corresponding to numbers in input string))) - as for loop based recursion -- not sure
class Solution {
    HashMap<Character,String> map;
    List<String> result;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        result = new ArrayList<>();
        List<String> tempo = new ArrayList<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        for(int i=0;i<digits.length();i++){
            char ch = digits.charAt(i);
            String temp = map.get(ch);
            tempo.add(temp);
        }
        if(tempo.isEmpty()) return result;
        helper(tempo,0, new StringBuilder());
        return result;
    }
    private void helper(List<String> allStrings, int idx, StringBuilder sb){
        // base
        if(idx==allStrings.size()){
            StringBuilder s = new StringBuilder(sb);
            result.add(s.toString());
            return;
        }else if(!sb.isEmpty()){
            StringBuilder s = new StringBuilder(sb);
            // result.add(s.toString());
        }
        // logic
        String temp = allStrings.get(idx);
        for(int i=0;i<temp.length();i++){
            sb.append(temp.charAt(i)); //action
            System.out.println(sb.toString());
            helper(allStrings,idx+1,sb); //recurse
            sb.deleteCharAt(sb.length()-1); //backtrack

        }
    }
}