
// Time - O(k) it refers to no of valid permutations
// Space - O(n) visited array of size n

class Solution {


    int count;
    public int countArrangement(int n) {

        int[] visitedpath = new int[n+1]; // path is visited path
        backtrack(n, 1, visitedpath);

        return count;



    }


    private void backtrack(int n, int index, int[] visitedpath) {

        // base

        if(index > n) {

            count = count + 1;
            return;

        }



        // logic

        for(int i = 1; i <= n; i++) {

            // action


            //choose
            if(visitedpath[i] == 0 && (index % i == 0 || i % index == 0)) {
                visitedpath[i] = 1; //if visited it would be 1
                System.out.println(index + " " + i);
                backtrack(n,index+1,visitedpath);
                visitedpath[i] = 0;  //backtrack
            }

        }



    }


}