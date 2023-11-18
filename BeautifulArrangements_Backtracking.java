import java.util.Scanner;
import java.util.HashSet;

public class BeautifulArrangements_Backtracking {


        //RECURSION WITH BACKTRACKING - O(N!)

        private int count;

        public int countArrangement(int n) {

            this.count = 0;

            // build an array with elements 1 to n for set to access while adding elements
            int[] num = new int[n];

            for(int i = 1; i <= n; i++) {

                num[i - 1] = i;
            }

            // set to keep arrangements
            HashSet<Integer> set = new HashSet<>(); //O(N) - space

            // recursion on each element of array
            for(int i = 0; i < n; i++) {

                //action
                set.add(num[i]);

                //recurse
                recurseBacktrack(num, set, n);

                //backtrack
                set.remove(num[i]);
            }
            //output
            return count;
        }

        private void recurseBacktrack(int[] num, HashSet<Integer> set, int n) {

            //base
            // if valid full length permutation is formed, increase count and return
            if(set.size() == n) {

                count++;
                return;
            }

            //logic
            //action
            for(int i = 0; i < n; i++) {

                // add if element no there, proceed if already there
                if(!set.contains(num[i])) {

                    set.add(num[i]);
                } else {
                    //N! step
                    continue;
                }

                //check before recursion
                boolean check = isBeautiful(num[i], set.size());

                //conditional recursion
                if(check) {

                    recurseBacktrack(num, set, n);
                }

                //backtrack
                set.remove(num[i]);

            }
        }

        private boolean isBeautiful(int element, int position) {

            //
            return element % position == 0 || position % element == 0;
        }

        public static void main(String[] args) {

            BeautifulArrangements_Backtracking obj = new BeautifulArrangements_Backtracking();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter n: ");
            int n = scanner.nextInt();

            int answer = obj.countArrangement(n);

            System.out.println("Number of beautiful arrangements for n = " + n + " is " +  answer);
        }

}

/*
TIME COMPLEXITY = O(N!)
At each level of recursion tree, possibilities reduce by 1 (as just added element above can't be added twice below)

SPACE COMPLEXITY = O(N) - recursive stack space
set also occupies o(N) space
*/