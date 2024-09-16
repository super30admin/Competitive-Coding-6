'''
    Time Complexity:
        O(k) (where k = number of arrangements)

    Space Complexity:
        O(n) (for the visited array)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Backtracking.
        Continue the path only if the current processing number and index are beautiful.
'''

class Solution:
    def __init__(self):
        self.n = 0
        self.visited = []
        self.count = 0

    def countArrangement(self, n: int) -> int:
        self.n = n
        self.visited = [False] * n
        self.backtrack(1)
        return self.count

    def backtrack(self, index):
        if index > self.n:
            self.count += 1
            return

        for num in range(1, self.n + 1):
            if self.visited[num - 1]:
                continue

            if (num % index == 0) or (index % num == 0):
                self.visited[num - 1] = True
                self.backtrack(index + 1)
                self.visited[num - 1] = False
