
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Solution {
    int result;
    bool[] visited;
    public int CountArrangement(int n) {
        result = 0;
        if(n == 0)
            return result;
        //we need to use visited array of n+1 because out i is between 1 to n and visited aray will be 0 indexed based
        //and in backtrackign we will start with 1st index
        visited = new bool[n+1];
        backtracking(n, 1);
        
        return result;
    }
    
    private void backtracking(int n, int index)
    {
        //base
        //we need to check n+1 becuase our visited array is of size n+1, that where we know we checked all posiible elements in current stack
        if(n+1 == index)
        {
            result++;
        }
        
        //logic
        for(int i = 1; i <= n; i++)
        {
            //action
            if((index % i == 0 || i % index == 0) && !visited[i])
            {
                visited[i] = true;
                            
                //recursion
                backtracking(n, index+1);

                //backtrack
                visited[i] = false;
            }
        }
    }
}