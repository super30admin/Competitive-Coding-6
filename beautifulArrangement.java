    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/palindrome-partitioning/
    Time Complexity for operators : o(n^n) .. n is the length of the string
    Extra Space Complexity for operators : o(n) for (List<String> path) without recursive stack
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. Backtracking
                    A) Call the backtracking function from main fucntion with initial values.
                    B) The backtracking function will contains input as string candidates, taregt, path, index.
                    C) Base case, index >= s.length() then we passed index then return.
                    F) In the main backtracking for loop(temp = to get the substring), check if it is palindrom and then add element to the list
                    E) then do backtracking, call backtracking function by passi for index+1.
                    F) At the end, remove last element from the String.
                    G) In main function, return final output.

    */  

class Solution {
    public int countArrangement(int N) {
        // int count = 0;
        backtracking(N,new ArrayList<>(),new HashSet<>(), 1);
        return count;
    }
    int count = 0;
    
    private void backtracking(int N,List<Integer> path,HashSet<Integer> hashSet,int position){
        //base
        if(path.size()==N){
            count +=1;
            return;
        }
        
        //backtracking
        for(int i=1;i<=N;i++){
            if(!hashSet.contains(i) && isValidDivision(i,position)){
                path.add(i);
                hashSet.add(i);
                backtracking(N,path,hashSet,position+1);
                hashSet.remove(i);
                path.remove(path.size()-1);
            }   
        }
    }
    
    private boolean isValidDivision(int i,int position){
        return (i%position == 0 || position%i == 0);
    }
}

// if N == 3
// 1,2,3

// 2,1,3

// 3,2,1