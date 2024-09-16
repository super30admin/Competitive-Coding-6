# Letter Case Permutation - 784 - https://leetcode.com/problems/letter-case-permutation/
# Time complexity - O(2^N) # N is the number of letters in a word
# Approach - Backtracking approach 



class Solution(object):
    def letterCasePermutation(self, s):
        """
        :type S: str
        :rtype: List[str]
        """
        res=[]
        path=""
        idx=0
        self.backtrack(s,res,path,idx)
        return res
    
    
    def backtrack(self,s,res,path,idx):
        #base case
        if idx==len(s):
            res.append(path)
            return res
        if s[idx].isalpha():
            self.backtrack(s,res,path+s[idx].upper(),idx+1)
            self.backtrack(s,res,path+s[idx].lower(),idx+1)
        else:
            self.backtrack(s,res,path+s[idx],idx+1)
        
            
        