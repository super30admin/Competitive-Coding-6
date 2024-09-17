// Time Complexity : O(k), k - no. of valid permutations
// Space Complexity : O(n), n - length of extra space used
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeautifulArrangement {

    int counter;
    int len;
    List<List<Integer>> result;
    public int countArrangement(int n) {
        result = new ArrayList<>();
        int[] arr = new int[n+1];
        counter = 0;
        len = n;
        helper(arr, 1);
        // System.out.println("Valid permuatations : " + result.toString());
        return counter;
    }

    private void helper(int[] arr , int num){
        //base
        if(num > len){
            counter++;
            System.out.println(Arrays.toString(arr));
            // result.add(Arrays.asList(arr));
            return;
        }
        //logic

        for(int i = 1 ; i <= len; i++){
            if(arr[i] == 0 && (num % i == 0 || i % num == 0)){
                //action
                arr[i] = num;
                //recursion
                helper(arr, num + 1);
                //backtrack
                arr[i] = 0;
            }
        }
    }
}
