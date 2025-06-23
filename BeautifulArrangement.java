// Time Complexity : O(n!)
// Space Complexity : O(n)

// My Approach - The approach was to make all possible permutation with each possible  index
// and keeping a for loop for that to check if the position is valid then only continue to make the complete permutation
// otherwise check the next possible permutation
import java.util.*;
public class BeautifulArrangement {
    static int countArrangement(int n) {

        return countPerm(n, new HashSet<>(), 1);

    }

    static int countPerm(int n,HashSet<Integer> set, int ind) {
        if(ind > n) return 1;

        int count = 0;
        for(int i = 1; i < n+1; i++) {
            if(!set.contains(i) && isBeautiful(ind, i)) {
                set.add(i);
                count += countPerm(n, set, ind+1);
                set.remove(i);
            }
        }
        return count;
    }
    static boolean isBeautiful(int ind, int val) {

        return ((ind % val == 0) || (val % ind == 0));
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Number of beautiful arrangements: " + countArrangement(n));
    }
}
