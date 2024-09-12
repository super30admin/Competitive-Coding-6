// Passed test cases on leetcode
class Solution {
    // O(n!) - Time complexity where n! represnets number of permutations of the given input n
    //O(n) - Space complexity to store auxilary array res[] here.
    int cnt = 0;
    void permut(int res[], int val, int n)
    {
            if(val > n)
            {
                cnt ++;
                return;
            }
            
            for(int i =1; i<= n; i++)
            {
                if(res[i] ==0 && (val % i ==0 || i % val ==0))
                {
                    res[i] = val;
                    permut(res,val +1,n);
                    res[i] = 0;
                }
            }
    }
        
    
    public int countArrangement(int n) {
        
        int res[] = new int[n+1];
        permut(res, 1, n);
        return cnt;
    
        
    }
}
