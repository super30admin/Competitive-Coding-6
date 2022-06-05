# Time Complexity : O(n!) where n is total numbers
# Space Complexity : O(n) where n is total numbers
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = 0
    def countArrangement(self, n: int) -> int:
        self.permutationHelper(n, set(), [], 0)
        return self.result
        
    def permutationHelper(self, n, permSet, path, index):
        #base
        if len(path) == n:
            self.result += 1
            return
        
        #logic
        for num in range(1, n+1):
                if (index + 1) % (num) == 0 or (num) % (index + 1) == 0:
                    if num not in permSet:
                        permSet.add(num)
                        path.append(num)
                        self.permutationHelper(n, permSet, path, index + 1)
                        permSet.remove(num)
                        path.pop()