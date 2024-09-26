//TC: O(k) where k is number of valid arrangements
//SC: O(n) where n is number of integers

class Solution {
public:
    //temporary array to store the current permutation being checked
    vector<int> temp;
    //visited map to check if a node has been visited or not
    unordered_map<int, bool> visited;
    int count=0;

    //function to backtrack
    void backtrack(vector<int>&temp, int n){
      if(temp.size() == n){
        count++;
        return;
      }

      for(int i=1; i<=n; i++){
        if(visited[i]){
            //if we have already visited one node, set continue
          continue;
        } 

        if(i%(temp.size()+1) == 0 || (temp.size()+1)%i==0){
          //set visited to true and push back to temp
          visited[i] = true;
          temp.push_back(i);
          backtrack(temp, n);
          //pop from temp after done evaluating all combinations with the number at that location
          temp.pop_back();
          visited[i] = false;
        }
      }

      return;
    }


    int countArrangement(int n) {

        backtrack(temp, n);
        return count;       
        
        
        
    }
};