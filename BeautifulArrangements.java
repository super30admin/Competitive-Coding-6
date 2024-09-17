/*
 * #526. Beautiful Arrangement
 * 
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

1. The number at the ith position is divisible by i.
2. i is divisible by the number at the ith position.
 

Now given N, how many beautiful arrangements can you construct?

Example 1:

Input: 2
Output: 2

Explanation: 

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 

Note:

1. N is a positive integer and will not exceed 15.

 */


/*
 * Time Complexity: k * O (k) -> Number of valid permutations for each integer at a particular position/index
 * 
 * Space Complexity: O (N) -> O(n). visited array of size n is used. The depth of recursion tree will also go up to n. Here, n refers to the given integer n.
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.competitivecoding6;

public class BeautifulArrangements {
	int[] beautifulArr;
    int count;
    public int countArrangement(int N) {
        beautifulArr = new int[N+1]; // starts with index 0 so N+1 size of array
        count = 0; // To keep track of number of beautiful arrangements
        
        
        backTracking(N,1); // Initiate the permutations of integers to get a beatiful arrangement, 1 is the index/position
        return count;
        
    }
    
    public void backTracking(int n, int pos){
        
        // Base Case
        if(pos > n){ // 'pos' is index
            count++; // We have a beatiful arrangement
        }
        
        for(int i = 1; i <= n; i++){ // 'i' is the number/integer
            // Check if the integer is not already being placed in array and it satisfies any of the two conditions given in problem description
            if(beautifulArr[i] == 0 && (pos % i == 0 || i % pos == 0)){
                beautifulArr[i] = 1; // Mark the integer as placed in array
                
                // Recursive call to try to place each of the numbers at each position
                backTracking(n, pos+1);
                
                // backtrack, explore the other permutation for a number
                beautifulArr[i] = 0; // Mark the integers as not placed again 
            }
        }
    }
    
}
