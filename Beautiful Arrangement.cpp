//Time Complexity- O(k) //number of permutations
//Space Complexity- O(n)

class Solution {
public:
    int countArrangement(int n) {
        
        unordered_set<int> values;
        int count=0;
        helper(count,n,values);
        return count;
    }
    
    void helper(int &count,int n,unordered_set<int> &values){
        
        if(values.size()==n){
            count++;
            return;
        }
        
        for(int i=1;i<=n;i++){
            int size=values.size()+1;
            if(values.find(i)==values.end() && (size%i==0 || i%size==0)){
                values.insert(i);
                helper(count,n,values);
                values.erase(i);
            }
        }
    }
};