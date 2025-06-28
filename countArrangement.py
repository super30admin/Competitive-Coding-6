# Time complexity: O(n!)
# Space complexity: O(n)

class Solution:
    def countArrangement(self, n: int) -> int:
        visited = [False] * (n + 1)
        self.count = 0

        def backtrack(index):
            if index > n:
                self.count += 1
                return
            for i in range(1, n + 1):
                if not visited[i] and (index % i == 0 or i % index == 0):
                    visited[i] = True
                    backtrack(index + 1)
                    visited[i] = False

        backtrack(1)
        return self.count
