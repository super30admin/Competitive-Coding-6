// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// Approach 1:
// we create an array of size n . start with first index, we have n options to fill it with a number. after filling 
// we place that number into set(to avoid repeated inclusion) , we then backtrack by removing it from the set.
// so, each time a particular index will have options from 1 to n (we check that it shouls not present in the set).
// when we complete all indices, we increment out count.
// Time Complexity : O(k) no. of valid permutations.
// Space Complexity : O(n)

class Solution {
public:
    int cnt = 0;
    unordered_set<int>set;
    int countArrangement(int n) {
        vector<int>arr(n+1,0);
        dfs(arr,1);
        return cnt;
    }
    void dfs(vector<int>&arr,int index)
    {
        if(index==arr.size())
        {
            cnt++;
            return;
        }
        for(int i = 1;i<arr.size();i++)
        {
            if((set.find(i)==set.end()) && (i%index==0 || index%i==0))
            {
                set.insert(i);
                dfs(arr,index+1);
                set.erase(i);
            }
            
        }
    }
};

// Approach 2:
// here we try to fix a number at any position from 1 to n. and each time loop from index 1 to n.
// so, we check if arr[i] == 0, that means that index is not yet filled with any value.
// whenever our condition satisfies, we change the value arr[i] == curr_num and at last we backtrack.
// when all our numbers are filled at all positions, we increment our count.
// Time Complexity : O(k)
// Space Complexity : O(n)

class Solution {
public:
    int cnt = 0;
    int countArrangement(int n) {
        vector<int>arr(n+1,0);
        dfs(arr,1,n);
        return cnt;
    }
    void dfs(vector<int>&arr,int curr_num,int end_num)
    {
        if(curr_num>end_num)
        {
            cnt++;
            return;
        }
        for(int i = 1;i<arr.size();i++)
        {
            if(arr[i] == 0 && (i%curr_num==0 || curr_num%i==0))
            {
                arr[i] = curr_num;
                dfs(arr,curr_num+1,end_num);
                arr[i] = 0;
            }
        }
    }
};

// Approach 3:
// It is same like approach 2, but instead of changing the values in the array, we are swapping them with all possible numbers.
// we then use backtracking.

// Time Complexity : O(k)
// Space Complexity : O(n)

class Solution {
public:
    int count = 0;
    int countArrangement(int n) {
        vector<int>arr(n,0);
        for(int i = 0;i<n;i++) arr[i] = i + 1;
        dfs(arr,0);
        return count;
    }
    void dfs(vector<int>&arr,int index)
    {
        if(index==arr.size())
        {
            count++;
            return;
        }
        for(int i = index;i<arr.size();i++)
        {
            swap(arr[index],arr[i]);
            if(arr[index]%(index+1) == 0  || (index+1)%arr[index] == 0)
            {
                dfs(arr,index+1);
            }
            swap(arr[index],arr[i]);
        }
    }
};