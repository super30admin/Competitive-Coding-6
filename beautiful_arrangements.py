# Time Complexity : O(n!)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
class Solution:
    def helper(self, n, index):
        # base
        if index > n:
            self.count += 1
            return
        # logic
        for i in range(1, n+1):
            if self.visited[i-1]:
                continue
            if index % i == 0 or i % index == 0:
                self.visited[i-1] = True
                self.helper(n, index + 1)
                self.visited[i-1] = False

    def countArrangement(self, n: int) -> int:
        self.count = 0
        self.visited = [False] * n
        self.helper(n, 1)
        return self.count


print(Solution().countArrangement(3))
