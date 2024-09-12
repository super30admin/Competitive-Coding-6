// Time Complexity : O(2*n)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
/*
Approach:
1) In this we have to generate permutations, and then compare the arrangements and count the beautiful arrangements.
2) lets say we have N=3 
the arrangements would be 
[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]

Now the beautiful arrangements would be 
        -> A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

        perm[i] is divisible by i.
        i is divisible by perm[i].

Thus we can have a backtracking approach
3) we get a set thus we don't add up same numbers. Thus set will help us. 
4) we have a loop from 1 to N included. if set does not have the number, then we add the element in set, and still perform backtracking
*/

import java.util.*;

public class BeautifulArrangement{
    
    int count;
    public int countArrangement(int n) {
     Set<Integer> set = new HashSet<>();
     helper(n,set,1);
      return count;
      
    }
    
    public void helper(int n, Set<Integer> set,int index)
    {
        // base case
        if(index>n)
        {
            count++;
            return ;
        }
        
        
        // logic case
        for(int i=1;i<=n;i++)
        {
            if(!set.contains(i) && ((index%i)==0 || (i%index)==0))
            {
                // add in set
                set.add(i);
                
                // recurse
                helper(n,set,index+1);
                
                // backtrack
                set.remove(i);
                
            }
        }
        
        
    }
    
    

}
