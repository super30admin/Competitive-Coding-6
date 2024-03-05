// Time Complexity :  O(k) [k: number of valid permutations]
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    int cnt;
    int N;

    public int countArrangement(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        // helperPermute(arr, 0);
        helperPermuteBackwards(arr, n-1);
        N = n;
        // backtrack(new boolean[n + 1], 1);
        // backtrackBackwards(new boolean[n + 1], N);
        return cnt;
    }

    private boolean isBeautPosition(int arr[], int i) {
        return isBeautifulPos(arr[i], i+1);
    }

    private boolean isBeautifulPos(int i, int j) {
        if ((i % j != 0) && (j % i != 0)) {
            return false;
        }
        return true;
    }

    //TC: O(k) [k: number of valid permutations]
    //SC: O(n)
    private void backtrack(boolean visited[], int idx) {

        // Base
        if (idx > N) {
            cnt++;
            return;
        }

        // logic
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && isBeautifulPos(i, idx)) {
                visited[i] = true;
                backtrack(visited, idx + 1);
                visited[i] = false;
            }
        }
    }

    //TC: O(k) [k: number of valid permutations]
    //SC: O(n)
    private void backtrackBackwards(boolean visited[], int idx) {
        // System.out.println("pivot: " + idx + "   idx:" + Arrays.toString(visited));
        // Base
        if (idx == 0) {
            cnt++;
            return;
        }

        // logic
        for (int i = N; i >= 1; i--) {
            if (!visited[i] && isBeautifulPos(i, idx)) {
                visited[i] = true;
                backtrackBackwards(visited, idx - 1);
                visited[i] = false;
            }
        }
    }

    //TC: O(k) [k: number of valid permutations]
    //SC: O(n)
    private void helperPermute(int arr[], int pivot) {
        // base
        if (pivot == arr.length) {
            cnt++;
            return;
        }

        // logic
        for (int i = pivot; i < arr.length; i++) {
            swap(i, pivot, arr);
            if (isBeautPosition(arr, pivot)) {
                helperPermute(arr, pivot + 1);
            }
            swap(i, pivot, arr);
        }
    }

     //TC: O(k) [k: number of valid permutations]
    //SC: O(n)
    private void helperPermuteBackwards(int arr[], int pivot) {
        // System.out.println("pivot: " + pivot + "   arr:" + Arrays.toString(arr));
        // base
        if (pivot == 0) {
            cnt++;
            return;
        }

        // logic
        for (int i = pivot; i >= 0; i--) {
            swap(i, pivot, arr);
            if (isBeautPosition(arr, pivot)) {
                helperPermuteBackwards(arr, pivot - 1);
            }
            swap(i, pivot, arr);
        }
    }


    private void swap(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}