# Time Complexity : O(n!) where n is total numbers
# Space Complexity : O(n) where n is total numbers
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = 0
    def countArrangement(self, n: int) -> int:
        self.permutationHelper(n, set(), [])
        return self.result
        
    def permutationHelper(self, n, permSet, path):
        #base
        if len(path) == n:
            c = 0
            for i in range(len(path)):
                if path[i] % (i+1) == 0 or (i+1) % path[i] == 0:
                    c += 1
            if c == n:
                self.result += 1
            return
        
        #logic
        for i in range(1, n+1):
            if i not in permSet:
                permSet.add(i)
                path.append(i)
                self.permutationHelper(n, permSet, path)
                permSet.remove(i)
                path.pop()