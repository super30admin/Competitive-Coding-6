// Time Complexity : O(n!)
// Space Complexity : O(n)
    // n - max level of recursion

import java.util.ArrayList;
import java.util.List;

class BeautifulArrangement {
    int count = 0;

    private void helper(List<Integer> arr, int pivot, int n){
        // base case
        if(pivot == n){
            count++;
            return;
        }

        for(int index = pivot; index < n; index++){
            // check is beautiful or not
            // swap pivot with index
            int temp = arr.get(pivot);
            arr.set(pivot, arr.get(index));
            arr.set(index, temp);

            if(arr.get(pivot)% (pivot+1) == 0 || (pivot+1) % arr.get(pivot)==0){
                //recurse
                helper(arr, pivot+1, n);
            }

            // backtrack
            temp = arr.get(pivot);
            arr.set(pivot, arr.get(index));
            arr.set(index, temp);
        }
    }

    public int countArrangement(int n) {
        List<Integer> arr = new ArrayList<>();

        for(int index = 1; index <=n ; index++){
            arr.add(index);
        }

        helper(arr, 0, n);

        return count;
    }
}