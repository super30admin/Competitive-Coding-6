# Time Complexity: O(N) # N is number of beautiful arrangments
# Space Complexity: O(n)

class Solution:
    def countArrangement(self, n: int) -> int:
        visited = [0 for i in range(n)]
        ba_count = 0

        def helper(n, i):
            # base
            if i >= n:
                ba_count += 1
                return

            for j in range(1, n+1):
                if visited[j - 1] == 0 and (j % (i+1) == 0 or (i+1)%j == 0):
                    visited[j-1] = 1
                    helper(n, i+1)
                    visited[j-1] = 0

        helper(n, 0)

        return ba_count
