// Time Complexity :O(nl) length of input string * average length of each dictionary
// Space Complexity :O(n) lenght of the input string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
*/



#include<iostream>
#include<vector>
#include<string>

using namespace std;

class Solution {
    vector<string> res;
    vector<string> hash_map{
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    void helper(string& digits,int level,string& s){
        //base case
        if(level == digits.length()){
            string s_push(s);
            res.push_back(s_push);
            return;
        }

        int hash_id = digits.at(level) - '2';
        string hash_val = hash_map[hash_id];

        for(int i{};i<hash_val.length();++i){
            s.push_back(hash_val.at(i));
            helper(digits,level+1,s);
            s.pop_back();
        }
    }
public:
    vector<string> letterCombinations(string digits) {
        if(digits == "") return res;
        string s{""};
        helper(digits,0,s);
        return res;
    }
};