// TC - O(N!)
// SC - O(N)

public class BeautifulArrangement {
    class Solution {
        private int count;

        public int countArrangement(int n) {
            int[] permuteArray = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                permuteArray[i] = i;
            }

            countBeautifulArrangement(permuteArray, 1);

            return count;
        }

        private void countBeautifulArrangement(int[] permuteArray, int index) {
            if (index == permuteArray.length) {
                count++;
                return;
            }

            for (int i = index; i < permuteArray.length; i++) {
                swap(permuteArray, index, i);
                if (permuteArray[index] % index == 0 || index % permuteArray[index] == 0) {
                    countBeautifulArrangement(permuteArray, index + 1);
                }
                swap(permuteArray, index, i);
            }
        }

        private void swap(int[] permuteArray, int index1, int index2) {
            int temp = permuteArray[index1];
            permuteArray[index1] = permuteArray[index2];
            permuteArray[index2] = temp;
        }
    }
}