class Solution {
    int count;
    public int countArrangement(int n) {
        count=0;
        boolean visited[]=new boolean[n+1];
        helper(1,n, visited);
        return count;
    }
    void helper(int start,int n, boolean[] visited){
        if(start==n+1)
            count++;
        for(int i=1;i<=n;i++){
            if(!visited[i]&&(start%i==0||i%start==0)){
                visited[i]=true;
                helper(start+1,n,visited);
                visited[i]=false;  
            }
        }
    }
}

//Time complexity - O(p) where p is the number of valid permutations 
//Space complexity - O(n) number of elements n for visited array
