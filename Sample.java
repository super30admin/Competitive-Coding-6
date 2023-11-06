
// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this


// Your code here along with comments explaining your approach

// https://leetcode.com/problems/beautiful-arrangement/

class Solution {
    int count;
    public int countArrangement(int n) {
        helper(n, 1, new ArrayList<>());
        return count;
    }

    private void helper(int n, int index, List<Integer> path){
        if(index > n){
            count++;
            return;
        }
        for(int i=1; i<=n; i++){
            if(!path.contains(i) && (index % i == 0 || i% index==0)){
                path.add(i);
                helper(n, index+1, path);
                path.remove(path.size() - 1);
            }
        }
    }
}