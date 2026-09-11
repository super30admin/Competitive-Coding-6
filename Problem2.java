
//Beautiful Arrangement
// using dfs and backtracking
//used extra array of n size O(n) space complexity
// O(n!) time complexity as we have n , n-1 , n-2 possibilities for every recursion


class Solution {
    int result;
    public int countArrangement(int n) {

        this.result = 0;
        helper(n , 1 , new int[n + 1]);
        return result;
        
    }

    public void helper(int n , int index,  int[] usedArray){

        if(index > n ){
            result++;
            return;

        }

        for(int i = 1; i <= n ; i++){

            if(usedArray[i] == 0 && (index % i == 0 || i % index == 0)){
                usedArray[i] = i;
              helper(n , index+ 1, usedArray);
              usedArray[i] = 0;
                
            }
            

        }
    }
}
