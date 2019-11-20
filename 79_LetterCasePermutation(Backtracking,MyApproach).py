'''
Accepted on leetcode(784)
Time - Exponencial , O(2^N), Space - O(1)

'''


class Solution(object):
    result = None

    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        Solution.result = []
        if len(S) == 0: return Solution.result
        self.helper(S, 0, "")
        return Solution.result

    def helper(self, s, start, temp):
        # base case
        if len(temp) == len(s) and start <= len(s):
            Solution.result.append(temp)
        # logic
        for i in range(start, len(s)):
            if s[i].isdigit():
                self.helper(s, i + 1, temp + s[i])
            else:
                sub = s[i].upper()
                self.helper(s, i + 1, temp + sub) # consider uppercase
                sub = s[i].lower()
                self.helper(s, i + 1, temp + sub) # consider lowercase and backtrack for both cases

            temp = temp[:-1]

sol = Solution()
print(sol.letterCasePermutation("a1b2"))