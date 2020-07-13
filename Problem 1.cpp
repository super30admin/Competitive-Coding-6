//Time Complexity : O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    int count=0;
    void backtrack(vector<int>& arr, int idx){
        if(idx==arr.size()){
            count+=1;
            return ;
        }
        
        for(int i=0; i<arr.size(); i++){
            arr[i]=arr[idx];
            arr[idx] = arr[i];
            
            if((arr[idx]%(idx+1)==0) || ((idx+1)%arr[idx]==0))
                backtrack(arr, idx+1);
            
            arr[idx]=arr[i];
            arr[i]=arr[idx];
        }
    }
    int countArrangement(int N) {
        vector<int> arr;
        for(int i=1; i<=N; i++){
            arr.push_back(i);
        }
        backtrack(arr, 0);
        return count;
    }
};