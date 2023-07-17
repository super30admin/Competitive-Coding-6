// Time Complexity: O(nLogn) + O(k) + O(klogk)
// Space Complexity: O(1)

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int index = bSearch(arr, x);
        cout << index << endl; 
        int ptr1 = index-1; 
        int ptr2 = index; 
        vector<int> result; 

        while(k > 0) {
            if(ptr1 >= 0 && ptr2 < arr.size()) {
                if(abs(arr[ptr1] - x) <= abs(arr[ptr2] - x)) {
                    result.push_back(arr[ptr1]);
                    ptr1--;
                } else {
                    result.push_back(arr[ptr2]);
                    ptr2++;
                }    
            } else if(ptr1 <= 0 && ptr2 < arr.size()) {
                result.push_back(arr[ptr2]);
                ptr2++;
            } else {
                result.push_back(arr[ptr1]);
                ptr1--;
            }

            k--;
        }

        sort(result.begin(), result.end());

        return result; 

    }

    int bSearch(vector<int>& arr, int x) {
        int low = 0; 
        int high = arr.size()-1; 
        int smallestDiff = INT_MAX;
        int smallDiff_Index = -1;  

        while(low < high) {
            int mid = (low+high)/2;
            if(arr[mid] >= x) {
                high = mid; 
            } else low = mid+1; 
            
        }

        return low;  
    }
};