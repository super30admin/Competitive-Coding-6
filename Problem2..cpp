//
// Created by shazm on 8/11/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution{
public:
  int problem(vector<vector<int>>& nums){
      int RoomCount = 0;
      if(nums.size()==0){
          return RoomCount;
      }
      vector<int> checkVec;
      sort(nums.begin(),nums.end());
      for(int x = 0; x<nums.size(); x++){
          if(x==0) {
              checkVec.push_back(nums[x][1]); RoomCount+=1;
          }else{
              bool check = true;
              for(int y = 0; y<checkVec.size(); y++){
                  if(nums[x][0]<checkVec[y]){
                      check = false;
                  }else{
                      checkVec[y] = nums[x][1]; check = true; break;
                  }
              }
              if(!check){
                  checkVec.push_back(nums[x][1]);
                  RoomCount+=1;
              }
          }
      }
      return RoomCount;
  }
};

int main(){
    Solution s;
    vector<vector<int>> vec{{0,30},{5,32},{15,20},{6,9}};
    cout<<s.problem(vec)<<endl;
    return 0;
}