
// Time Complexity : O(2^N) Exponential since we have 2 choices to make at every node in the worst case
// Space Complexity : O(1) if iteration used. O(N) since recursion used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

public class LetterCasePermutations {
        int count=0; //Optional: To keep track of total number of possibilities
        List<String> result = new ArrayList<>();
        public List<String> makePossibileStrings(String s){
            helper(s, 0, "");
            return result;
        }

        private int helper(String s, int index, String path){
            //base case :
            if(s.length()==0 || s==null || index>s.length()) return count;
            if(index==s.length()){
                result.add(path);
                return count;
            }
            count++;
            //logic
            char c = s.charAt(index);
            String temp = path;
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                //case : lowercase
                String path1 = path + Character.toLowerCase(c);
                count+=helper(s, index+1, path1);

                //case: upper case
                String path2 = temp + Character.toUpperCase(c);
                count+=helper(s, index+1, path2);
            }
            else{
                //case: Numeric value
                count+=helper(s, index+1, path+c);
            }
            return count;
        }

        public static void main (String[] args) {
            List<String> result = new makePossible().makePossibileStrings("a1b1");
            System.out.println("The total number of possibilities is: "+result.size());
            for(String path: result){
                System.out.println(path);
            }
        }
    }



