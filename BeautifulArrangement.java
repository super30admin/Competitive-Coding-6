//tc : O(n)
//sc: O(n)
public class BeautifulArrangement {
    int[] nums;
    boolean visited[];
    int count = 0;
    public int countArrangement(int n) {
        //if (n == 0 || n == 1) return 1;
        nums = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        backtracking(nums, 0, visited);
        return count;
    }
    private void backtracking(int nums[], int index, boolean[] visited)  {
        //base
        if (index > nums.length - 1) {
            count++;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (index % (i + 1) == 0 || (i + 1) % index == 0) {
                    visited[i] = true;
                    backtracking(nums, i + 1, visited);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String args[]) {
        BeautifulArrangement b = new BeautifulArrangement();
        System.out.println(b.countArrangement(4));
    }
}