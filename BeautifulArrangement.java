/*
This solution utilises DFS with backtracking. We maintain a set with capacity equal to the number of integers. We then go over each integer,
and place them in this set accordingly by checking the conditions for the beautiful arrangment. In this way, we check all the permutations of
the numbers in the set, and return the number of beautful arrangements.

Did this code run on leetcode: yes
*/
class Solution {
    boolean[] flag;
    int count;
    //Time Complexity: O(n!)
    //Space Complexity: O(n)
    public int countArrangement(int n) {
        //We initialise a boolean array at the same capacity as n, which will be used to track if there is already a number at a particular location or not
        flag = new boolean[n + 1];
        
        count = 0;
        
        helper(1, n);
        
        
        return count;
    }
    
    private void helper(int index, int n)
    {   //If the current number being placed goes beyond the amount of integers, we increase the count
        if(index > n)
        {
            count++;
            return;
        }
        
        for(int i = 1; i <= n; i++)
        {   //Before inserting a number at a particular position and recursing further, we check whether it satisfies the beatiful arrangement.
            //If it does not, then we do not search along that path. This way we optimise our time by eliminating some invalid paths
            if(!flag[i] && (index % i == 0 || i % index == 0))
            {
                flag[i] = true;
                helper(index + 1, n);
                flag[i] = false;
            }
        }
    }
}