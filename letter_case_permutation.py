"""
Given a string find all case permutations of a given letter

Time Complexity : O(2^N)
Space Complexity : O(N)

"""
class Solution(object):
    def is_number(self, s):
        try:
            int(s)
            return True
        except ValueError:
            return False
    
    def letterCasePermutation(self, s):
        if s == "":
            return [""]
        r = self.letterCasePermutation(s[1:])
        if self.is_number(s[0]):
            return [s[0] + i for i in r]
        else:
            return [s[0].upper() + i for i in r] + [s[0].lower() + i for i in r]
