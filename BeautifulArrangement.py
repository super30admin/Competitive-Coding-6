# Time Complexity : O(n!)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We generate all permutations of numbers from 1 to n using backtracking.
# At each position, we only place numbers that satisfy the divisibility condition with that position.
# If it's valid, we move forward; otherwise, we backtrack and try other numbers.

class Solution:
    def __init__(self):
        self.visited = []
        self.count = 0

    def countArrangement(self, n: int) -> int:
        self.visited = [False] * (n + 1)
        self.helper(n, 1)
        return self.count

    def helper(self, n, pos):
        if pos > n:
            self.count += 1
            return

        for i in range(1, n + 1):
            if not self.visited[i] and (i % pos == 0 or pos % i == 0):
                self.visited[i] = True
                self.helper(n, pos + 1)
                self.visited[i] = False