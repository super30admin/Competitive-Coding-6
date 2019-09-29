/*

Problems Faced: No
Solution Approach: Backtracking
Test case = "a1b2"
Recursion Tree
                " "
                / \
               a   A
               |   |
               1   1
               /\  /\
              b B  b B
              | |  | |
              2 2  2 2
Did it run on Leetcode: It is a locked leet code question.
This is the first time I am trying my submission using JAVA. Your comments will help
me to improve my code.

*/

import java.util.*;
import java.lang.*;
import java.io.*;


class PossibleStrings
{	
	private List<String> result;
	public PossibleStrings(){
		result = new ArrayList<String>();
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		
		String testString="a1b2";
		PossibleStrings possibleStrings = new PossibleStrings();
		possibleStrings.dfs(0,"",testString);
		possibleStrings.printResult();
		
	}
	
	public void dfs(int index,String currentString,String testString){
		
		if(index>testString.length()){
			return;
		}
		
		if(index==testString.length()){
			this.result.add(currentString);
			return;
		}
		
		if(Character.isDigit(testString.charAt(index))){
			this.dfs(index+1,currentString+testString.charAt(index)+"",testString);
		}else{
			String lowerCase = Character.toLowerCase(testString.charAt(index))+"";
			String upperCase = Character.toUpperCase(testString.charAt(index))+"";
			this.dfs(index+1,currentString+lowerCase,testString);
			this.dfs(index+1,currentString+upperCase,testString);
		}
		
	}
	
	public void printResult(){
		System.out.println("The strings are:");
		System.out.println(this.result.toString());
	}
}