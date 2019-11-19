
// Time Complexity : O(2^N)
// Space Complexity : O(1) + recursion stack
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :Nope


// Your code here along with comments explaining your approach

public class FindDifferentPossibilities{
	
	public static void main(String[] args){
		findDifferentPossibilities(a1b2);
	}
	
	public List<String> findDifferentPossibilities(String s){
		List<String> result = new ArrayList<>();
		if(null == s || 0 == s.length()){
			return result;
		}
		findDifferentPossibilities(s,0,"",result);
		return result;
	}

	private void findDifferentPossibilities(String s, int index, String res, List<String> result){
		if(index == s.length()){
			result.add(res);
			return;
		}
		if(Character.isDigit(s.charAt(index))){
			findDifferentPossibilities(s,index+1,res+s.charAt(index),result);
		}else{
			String temp = ""+(s.charAt(index));
			String first = res+temp.toLowerCase();
			findDifferentPossibilities(s,index+1,first,result);
			String second = res + temp.toUpperCase();
			findDifferentPossibilities(s,index+1,second,result);
		}
	}
}
