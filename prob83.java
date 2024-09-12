// package whatever; // don't place package name!

import java.io.*;

class MyCode {
  
  int count =0;
  public int count(int n){
    int[] nums = new int[n];
    for(int i =0; i<n; i++)
    nums[i] = i + 1;
    permute(nums, 0);
    
    return count;
  }
  
  private void permute(int[] nums, int k){
    if(k == nums.length)
    count++;
    for(int i = k; i< nums.length; i++){
      swap(nums, i, k);
      
      //logic
      if(nums[k] % (k+1) == 0 || (k+1) % nums[k]== 0)
      
      permute(nums, k+1);
      swap(nums, i, k);//backtrack
    }
  }
  private void swap(int[]nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
  
public static void main(String[] args){
    MyCode  abc = new MyCode();
    
    System.out.println(abc.count(17));
    
  }
}
