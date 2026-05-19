# https://leetcode.com/problems/beautiful-arrangement/

class Solution:
    def countArrangement(self, n):
        visited = [False] * (n + 1)
        self.result = 0
        self.helper(1, visited, n)
        return self.result

    def helper(self, pivot, visited, n):
        if pivot > n:
            self.result += 1
            return

        for i in range(1, n + 1):
            if not visited[i] and (pivot % i == 0 or i % pivot == 0):
                visited[i] = True
                self.helper(pivot + 1, visited, n)
                visited[i] = False
