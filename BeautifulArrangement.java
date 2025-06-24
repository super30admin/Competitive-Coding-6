//Time Complexity: Number of valid permutations i.e n!


class Solution {
    private int count;
    public int countArrangement(int n) {
        this.count = 0;
        boolean[] used = new boolean[n+1];
        helper(n, 1, used);
        return count;
    }

    private void helper(int n, int idx, boolean[] used){
        //base
        if(idx > n){
            count++;
            return;
        }

        //logic
        for(int num=1; num<=n; num++){
            if(!used[num] && (num % idx == 0 || idx % num == 0)){
                //action
                used[num] = true;

                //recurse
                helper(n, idx+1, used);

                //backtrack
                used[num]=false;
            }
        }
    }
}