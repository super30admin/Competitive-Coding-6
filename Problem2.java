
//Time Complexity: O(N!)
//Space Complexity: O(N)

//we use recursion and backtracking to find all the possible arrangements
//we use an array to keep track of the numbers that are already used in the arrangement
//if we reach the end of the arrangement, we increment the count of valid arrangements.
//we check for each number from 1 to n, if it is not used and if it satisfies the condition of being divisible by the position or vice versa    
//we mark the number as used and call the helper function for the next position
//after the call, we backtrack by marking the number as unused


class Solution {
    int ans;
    public int countArrangement(int n) {
        ans=0;
        int a[]=new int[n+1];
        helper(n,a,1);
        return ans;
    }
    public void helper(int n,int a[],int i){
        if(i>n){
            ans++;
            return;
        }
        for(int j=1;j<=n;j++){
            if(a[j]==0&&(j%i==0||i%j==0)){
                a[j]=i;
                helper(n,a,i+1);
                a[j]=0;
            }
        }
        
    }
}