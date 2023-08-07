//Problem 1: Beautiful Arrangement
// Time Complexity : O(n!) all possible combinations
// Space Complexity : O(n) array space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Approach -> check iteratively beautiful arrangement condition for every possible permutation, if matches, increment count
class Solution {
    //TC: O(n!) //SC O(n)
    int count;
    public int countArrangement(int n) {
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;// 1->n
        }
        backtracking(nums, 0); //recursive call
        return count;
    }
    private void backtracking(int[] nums, int idx){
        //base
        if(idx==nums.length){
            count++;
        }
        //logic
        for(int i=idx;i<nums.length;i++){ //not choose scenario handled by for loop
            //action
            swap(nums, i, idx); //swap for possible permutation of given array

            //recurse
            if(nums[idx]%(idx+1)==0 || (idx+1)%nums[idx]==0) //check for swapped index
                backtracking(nums, idx+1);
            
            //backtrack
            swap(nums, idx, i); //swap back to original position
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}



//Problem 2: Rate Logger Limiter
// Time Complexity : O(number of shouldPrintMessage calls)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Approach-> maintain hashmap for O(1) search and check if old time and new time diff is 10 and above, if yes, return true
class Logger {
    HashMap<String, Integer> map;
    public Logger() {
        this.map=new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message,timestamp);
            return true;
        }
        else{
            if(timestamp-map.get(message)>=10){
                map.put(message,timestamp);
                return true;
            }
            else
                return false;
        }
    }
}