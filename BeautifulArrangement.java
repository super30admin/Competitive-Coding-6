// Time Complexity :O(n!)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
class Solution {
    int count;
    boolean placed[];
    public int countArrangement(int n) {
        count = 0;
        placed = new boolean[n+1];
        helper(1,1,n);
        return count;
    }
    private void helper(int position, int currentNum, int n){
        //base
        if(position>n){
            count+=1;
            return;
        }
        //logic
        if(currentNum>n) return;
        //choose
        if(!placed[currentNum] && (position%currentNum == 0 || currentNum%position == 0)){
            placed[currentNum] = true;
            helper(position+1,1,n);
            placed[currentNum] = false;
        }
        //no choose
        helper(position,currentNum+1,n);
    }
}