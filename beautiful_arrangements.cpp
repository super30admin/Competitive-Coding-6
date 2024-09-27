// Time Complexity : O(n!)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
private:
    int num_arrange = 0;
    
    void count_rec(vector<bool> &bool_arr, int pos)
    {
        if(pos == bool_arr.size())
        {
            num_arrange++;
            return;
        }
        
        pos++;
        
        for(int i = 0; i < bool_arr.size(); i++)
        {
            if(bool_arr[i] == 0)
            {
                if(!((i+1) % pos) || !(pos % (i+1)))
                {
                    bool_arr[i] = true;
                    
                    count_rec(bool_arr, pos);
                    
                    bool_arr[i] = false;
                }
            }
        }
    }
    
public:
    int countArrangement(int n) {
        
        int i;
        
        vector<bool> vect;
        for(i = 0; i < n; i++)
            vect.push_back(false);
        
        for(i = 0; i < n; i++)
        {
            vect[i] = true;

            count_rec(vect, 1);
            
            vect[i] = false;
        }
        
        return num_arrange;
    }
};