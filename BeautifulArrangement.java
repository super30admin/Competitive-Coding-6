package week6;

/*
* TC - worst: O(n!)
* TC - average: less than O(n!) due to pruning
* SC - O(n) used array and call stack depth.sa
* */

public class BeautifulArrangement {

        boolean[] used;
        int count = 0;

        public int countArrangement(int n) {
            used = new boolean[n + 1];
            helper(n, 1); // Start from position 1
            return count;
        }

        private void helper(int n, int pos) {
            if (pos > n) {
                count++;
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                    used[i] = true;
                    helper(n, pos + 1);
                    used[i] = false;
                }
            }
        }

}
