#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use recursion to solve this backtracking problem and as pos becomes greater than n we increment the count
inside the rescursive for loop if the modulus is 0 we swap the ith element with pos element
and then we return the count
*/
class Solution{
    int count;
public:
    int beautifulArrangement(int n){
        count = 0;
        vector<int> arr(n+1);
        for(int i=1; i<=n; i++) arr[i] = i;
        helper(arr, 1, n);
        return count;
    }
private:
    void helper(vector<int>& arr, int pos, int n){
        if(pos > n){
            count++;
            return;
        }
        for(int i=pos; i<=n; i++){
            if(arr[i]%pos == 0 || pos%arr[i] == 0){
                swap(arr[i], arr[pos]);
                helper(arr, pos+1, n);
                swap(arr[i], arr[pos]);
            }
        }
    }
};
