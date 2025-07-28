// Recursion and backtracking to find all arrangements that are beautiful
// TC: Exponential
// SC: O(n) 

class Solution {
    int count;
    int n;
    public int countArrangement(int n) {
        int[] path = new int[n+1];
        this.n = n;
        recurse(1, path);
        return count;
    }

    public void recurse(int current, int[] path){
        // Base
        if(current > n){
            System.out.println(Arrays.toString(path));
            count = count + 1;
            return;
        }
        // Logic
        for(int i=1;i<=n;i++){
            if(path[i]==0 && (current % i == 0 || i % current == 0)){
                path[i] = current;
                recurse(current+1, path);
                path[i] = 0;
            }
        }
    }
}
