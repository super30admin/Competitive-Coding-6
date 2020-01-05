# 784
# Runs on Leetcode
    # Runtime - exponential
    # Memory - O(n) including the recursive stack wher n is length of string


class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        if not s:
            return []
        
        if s.isdigit():
            return [s]
        
        self.result = []
        self.helper(s, 0, "")
        return self.result
        
    def helper(self, s, index, path):
        # edge case
        if index == len(s):
            self.result.append(path)
        else:    
            # logic
            # if the charcater is number?
            if s[index].isdigit():
                self.helper(s, index+1, path+s[index])
            # if it is an alphabet!
            else:
                self.helper(s, index+1, path + s[index].upper())
                self.helper(s, index+1, path + s[index].lower())
