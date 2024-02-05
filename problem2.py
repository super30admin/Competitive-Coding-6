#Time Complexity :O(n!)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :No


class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        self.dfs_helper(n, 1, [False] * (n + 1))
        return self.count
    
    def dfs_helper(self, n, index, visited):
        if index == n + 1:
            self.count += 1
            return
        for i in range(1, n + 1):
            if not visited[i] and (i % index == 0 or index % i == 0):
                visited[i] = True
                self.dfs_helper(n, index + 1, visited)
                visited[i] = False