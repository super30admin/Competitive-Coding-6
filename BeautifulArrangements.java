//BruteForce soln: Explore all permutations and check for conditions
//Bruteforce TC: O(n!*n) and SC: O(n!*n + n)
//using backtracking and visited array, we get 
//TC: O(n!)
//SC: O(n)


// Your code here along with comments explaining your approach


class Solution {
    private int count = 0;
    public int countArrangement(int n) {
        //sanity check
        
        if(n == 1){
            return 1;
        }
        //backtracking fn
        backtracking(n, new boolean[n+1], 1);
        
        return count;
        
    }
    
    public void backtracking(int n, boolean[] visit, int index){
        //base case
        if(index > n){//in=3, n=2
            count++;
            return;
        }
        //n=2
        for(int i=1;i <= n;i++){//1<=2
            if(visit[i] == true)
              continue;
            //conditions
            if(i % index == 0 || index % i == 0){ //index=2, i=1 => 1%2=1; 2%1=0
                visit[i]=true;  //v[1]=t
                //backtracking
                backtracking(n, visit, index+1);//bt(2,v, 3)
                //remove or make the visit false
                visit[i] = false;
            }
        }
    }
}
