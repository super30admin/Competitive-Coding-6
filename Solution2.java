class Solution {
    int count;
    boolean[] beautifulArr;
    public int countArrangement(int n) {
        count = 0;
        beautifulArr = new boolean[n+1];
        if(n == 0){
            return count;
        }
        helper(n,1);
        return count;
    }
    private void helper(int n, int pos){
        //base
        if(pos>n){
            count++;
        }
        //logic
        //action
        for(int i =1; i<=n;i++){
            if(beautifulArr[i] == false && (pos%i == 0 || i%pos ==0)){
                beautifulArr[i] = true;
            //recurse
            helper(n, pos+1);
            //backtrack
            beautifulArr[i] = false;
        }}
    }
}