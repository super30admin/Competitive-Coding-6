'''
Accepted on leetcode(784)
time - exponencial(O(2^N))
using recursion
'''
class Solution(object):
    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        lst = []
        if not S or len(S) == 0:
            lst.append("")
            return lst
        result = self.letterCasePermutation(S[1:]) # each time reducing the string length by 1 letter for recursion and checking consitions on first character in the string.
        for res in result:
            if S[0].isalpha():
                lst.append(S[0].lower()+res)
                lst.append(S[0].upper()+res)
            else:
                lst.append(S[0]+res)
        return lst