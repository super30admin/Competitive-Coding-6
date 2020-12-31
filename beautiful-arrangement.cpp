//Time complexity - O(N!)
//Space complexity - O(N)
class Solution {
public:
    int count = 0;
    int countArrangement(int N) {
        vector<int> arr (N+1,0);
        helper(arr,N,1); 
        return count;
    }
    void helper(vector<int>& arr, int N, int level){
        if(level == N+1) {count++;return;}
        for(int i = 1;i<=N;i++){
            if(arr[i]==0 && (level%i == 0 || i%level == 0)){
                arr[i] = level;
                helper(arr, N,level+1);
                arr[i] = 0;
            }
        }
    }
};