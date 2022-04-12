# Time Complexity : O(k) where k is permuntation
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def countArrangement(self, n):
        """
        :type n: int
        :rtype: int
        """
        self.res = 0
        self.backtrack(n, 1, [])
        return self.res
        
    def backtrack(self, N, pos, tempArr):
        if len(tempArr) == N:
            self.res += 1
            return
        
        for i in range(1, N+1):
            if i not in tempArr and (i % pos == 0 or pos % i == 0):
                tempArr.append(i)
                self.backtrack(N, pos+1, tempArr)
                tempArr.pop()