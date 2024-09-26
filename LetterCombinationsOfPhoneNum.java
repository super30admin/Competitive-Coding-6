https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class Solution {
    List<String> result = new ArrayList<>();
    Map<Character,char[]> map;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return result;
        map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        StringBuffer sb = new StringBuffer();
        backtrack(digits, 0 , sb);
        return result;
    }
    private void backtrack(String digits, int index , StringBuffer sb){
         if (index >= digits.length()) {
			result.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);
        char[] values = map.get(digit);
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            backtrack(digits, index+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

/*
Time complexity: O(3^L)
Space complextiy : O(1) hashmap is fixed and O(n) is the recursive stack space
*/