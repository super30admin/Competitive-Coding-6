// Time Complexity : O(n!)
// Space Complexity : O(n) the space to store in Hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class BeautifulArrangement {
    HashSet<Integer> set = new HashSet<>();
    int count = 0;
    public int countArrangement(int n) {

        helper(n);
        return count;
    }

    public void helper(int n) {
        //base
        if(set.size() == n) {
            count += 1;
        }

        //logic
        for(int i = 1; i <= n; i += 1) {
            if(!set.contains(i) && (i%(set.size()+1) == 0 || (set.size()+1)%i == 0)) {
                set.add(i);
                helper(n);
                set.remove(i);
            }
        }
    }

    public static void main(String [] args){
        BeautifulArrangement ba = new BeautifulArrangement();
        System.out.println(ba.countArrangement(4));
    }
}
