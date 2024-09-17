"""
Problem: 526. Beautiful Arrangement
Leetcode: https://leetcode.com/problems/beautiful-arrangement/
Approach: Backtracking DFS recursive
Time Complexity: O(k), k refers to the number of valid permutations.
Space Complexity: O(n), visited array of size n is used. The depth of recursion tree will also go upto n. Here, n refers to the given integer n.
"""


class Solution:
    count = 0

    def countArrangement(self, N: int) -> int:
        # base case
        if not N:
            return self.count

        visited = [0] * (N + 1)
        self.calculate(N, 1, visited)
        return self.count

    def calculate(self, N, pos, visited):
        if pos > N:
            self.count += 1

        for i in range(1, N + 1):  # 1,2,3
            if not visited[i] and (pos % i == 0 or i % pos == 0):
                visited[i] = 1
                self.calculate(N, pos + 1, visited)
                visited[i] = 0

