// Time Complexity : O(n!) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a hashSet and recurse through 1 to n
// if the no. is not in hashset add it
// check if the hashset size is divisible by the no. and vice versa
// If they are not return otherwise we will continue
// If the hashset size becomes equal to n increment counter
// Finally return the count
class Solution {
    int count;
    Set<Integer> hs;
    public int countArrangement(int n) {
        count = 0;
        hs = new HashSet();
        findBeauty(n, 1);
        return count;
    }
    private void findBeauty(int n, int start){
        //base
        if(hs.size()%start != 0 && start%hs.size() !=0)
            return;
        if(hs.size() == n){
            count++;
        }
        //recurse
        for(int i = 1; i <= n; i++){
            if(!hs.contains(i)){
                hs.add(i);
                findBeauty(n, i);
                hs.remove(i);
            }
        }
    }
}