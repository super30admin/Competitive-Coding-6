// Time Complexity : O(n!)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.HashMap;
import java.util.Map;

public class BeautifulNumber {

    public static void main(String[] args) {

        System.out.println(countArrangement(2));
    }

    public static int countArrangement(int n) {

        // Create a HashMap to keep track of whether a number has been used
        Map<Integer, Boolean> used = new HashMap<>();

        // Call the recursive method to count valid arrangements
        return countArrangements(n, 1, used);
    }

    private static int countArrangements(int n, int pos, Map<Integer, Boolean> used) {

        // Base case: If we have placed all numbers, return 1 to indicate a valid
        // arrangement
        if (pos > n) {
            return 1;
        }

        int count = 0;

        // Iterate over all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check if the number i has not been used and satisfies the condition for a
            // beautiful arrangement
            if (!used.getOrDefault(i, false) && (i % pos == 0 || pos % i == 0)) {
                // Mark the number i as used
                used.put(i, true);
                // Recursively count valid arrangements for the next position
                count += countArrangements(n, pos + 1, used);
                // Mark the number i as unused for backtracking
                used.put(i, false);
            }
        }

        // Return the total count of valid arrangements
        return count;
    }

}
