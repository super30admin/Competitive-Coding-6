// Time Complexity : O(N!*N) - N! for permutations and N for N elements

// Space Complexity : O(N) - recursion stack space

// Did this code successfully run on Leetcode : YES

// Appoarch: Recursion (generate permutations) + backtracking

// 526. Beautiful Arrangement

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:

    void helper(vector<int>& nums,int n,int pivot,int& count){
        if(pivot == n){
            count++;
            return;
        }
        for(int i=pivot;i<n;i++){
            if((nums[i]%(pivot+1)==0 || (pivot+1)%nums[i]==0)){
                swap(nums[pivot],nums[i]);
                helper(nums,n,pivot+1,count);
                swap(nums[pivot],nums[i]);
            }
        }
    }
    int countArrangement(int n) {
        vector<int> nums;
        int count=0;
        for(int i=1;i<=n;i++){
            nums.push_back(i);
        }
        helper(nums,n,0,count);
        return count;
    }
};