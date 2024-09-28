//
// Created by shazm on 8/11/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<string> letterCasePermutation(string S) {
        vector<string> retVec;
        if(S.size()==0){return retVec;}
        recurr(S,retVec,0);
        return retVec;
    }

private:
    void recurr(string S,vector<string>& retVec,int index){
        if(index>=S.size()){ //base
            retVec.push_back("");
            return;
        }

        recurr(S,retVec,index+1);
        if(isdigit(S[index])){
            for(int x = 0; x<retVec.size(); x++){
                retVec[x]=S[index]+retVec[x];
            }
        }else{
            int size = retVec.size();
            for(int x = size-1; x>=0; x--){
                string str = retVec[x];
                retVec.erase(retVec.begin()+x);
                retVec.push_back((tolower(S[index],locale()))+str);
                retVec.push_back((toupper(S[index],locale()))+str);
            }
        }
        return;
    }
};