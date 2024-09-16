//factorial TC, n!
//SC is O(n)

class Solution {
public:
   
    int count =0;
    vector<bool> isUsed(16,false);
    int countArrangement(int n) {
        //checking if number is used or not
        vector<bool> isUsed(n+1,false);
        generate_perms(isUsed,1,n);
        return count;
    }
    void generate_perms(int index, int n){
        //base
        if(index > n) {count++; return;}
        for(int i=1;i<=n;i++){
            if(!isUsed[i] && (index%i == 0|| i%index ==0)){
            isUsed[i]= true;   
            generate_perms(isUsed, index+1,n);      
            isUsed[i] = false;
            }
        }
    }
   
};
