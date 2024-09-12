// Time Complexity : I am not sure
// Space Complexity : Depth of the tree O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Need lots of practice

class Solution {
    int count = 0;
public:
    int countArrangement(int N) {
        vector<bool> visited(N+1);
        calculate(N,1,visited);
        return count;
    }
    void calculate(int N, int pos, vector<bool> visited){
        if(pos>N){
            count++;
        }
        for(int i=1;i<=N;i++){
            if(!visited[i] && (pos%i==0||i%pos==0)){
                visited[i] = true;
                calculate(N,pos+1,visited);
                visited[i] = false;
            }
        }
    }
};
