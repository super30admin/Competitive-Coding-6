// Time Complexity : O(k) : k is number of valid solutions
// Space Complexity : O(n), input 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    //keep a boolean array to check if a number is placed at that position
    boolean[] arr;
    //count variable to keep count of beautiful arragement 
    int count;
    public int countArrangement(int N) {   
        //since the numbers start from 1, the array size is N+1
        arr = new boolean[N+1];
        //initial count is 0
        count = 0; 
        //call backtrack with the N and index value 1
        backtrack(arr, N, 1);  
        //return count
        return count; 
    }
    
    private void backtrack(boolean[] arr, int N, int index) {
        //base case
        //if index (numbers placed is > N) (all numbers have been placed)
        //increase the count and return
        if(index > N) {
            count++; 
            return; 
        }
        
        //logic
        //for each array position (1 to N), if no number placed (false), 
        //place index (make it true) in the ith position 
        //if beautiful arragement condition satisfies
        for(int i = 1; i <= N; i++) {
            //if ith position is false
            if(arr[i] != true) {
                //Logic
                //check if beautiful arragement condition satisfies
                if( i % index == 0 || index % i == 0 ) {
                    //make ith position true (index is placed at the ith position)
                    arr[i] = true;
                    //Recursive
                    //call backtrack method again : to place next number (index+1)
                    backtrack(arr, N, index+1);
                    //Backtrack, make the ith position false 
                    arr[i] = false; 
                }
            } 
        }
    }
}
