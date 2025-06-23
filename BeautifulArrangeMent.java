// Time complexity - O(n!)
// Space compelxity - O(n)
// Solved on leetcod e- yes
// faced any issue s- nO
// The solution uses backtracking to try placing each number from 1 to n at each position (pivot) from 1 to n, checking if it satisfies the condition i % pivot == 0 || pivot % i == 0. A boolean array tracks which numbers have already been used to avoid repetitions. When all positions are filled validly (pivot > n), we increment the count of beautiful arrangements.
class Solution {
    int count =0;
    public int countArrangement(int n) {
        helper(n, 1, new boolean[n+1]);
        return count;
    }
    
    public void helper(int n, int pivot, boolean[] a) {
        // base
        if(pivot > n) {
            count++;
            return;
        } 

        //logic
        for(int i=1;i<=n;i++) {
            if((i%pivot == 0 || pivot%i==0) && !a[i]) {
            //action
            a[i] = true;
            helper(n, pivot+1, a);
            a[i] = false;
            }
        }
    }
}
