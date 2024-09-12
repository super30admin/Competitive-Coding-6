/*
// Time Complexity : O(n) n = possible valid permutations.
// Space Complexity :O(N) max number given.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//nope

// Your code here along with comments explaining your approach

*/
class Solution {
    List<Integer> temp;
    int ret;
    public int countArrangement(int N) {
        temp = new ArrayList<>();
        ret = 0;
        HashSet<Integer> seen = new HashSet<>();
        findAnagram(N,0,seen);

        return ret;
    }

    private void findAnagram(int N,int indx, HashSet<Integer> seen){
       //if temp size  == N , we know we found a valid permutations/anagram.
        if(temp.size() == N){
            ret++;
        }

        //if a number can be added to a pos. mark number as seen.
        //till that number is seen, can not be placed again.
        for(int i = 0 ; i < N; i++){
            int pos = indx+1;
            int val = i+1;
            if(!seen.contains(val)){

                if(val % pos == 0 ||
                   pos % val == 0){
                    seen.add(val);
                    temp.add(val);
                    findAnagram(N, pos , seen);
                    temp.remove(indx);
                    seen.remove(val);
                }
            }
        }
    }
}
