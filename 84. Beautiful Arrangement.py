class Solution:
    count = 0

    def countArrangement(self, n: int) -> int:
        visited = set()
        self.count = 0

        def helper(i):
            # base
            if len(visited) % i != 0 and i % len(visited) != 0:
                return

            if len(visited) == n:
                self.count += 1
                return

            # logic
            for i in range(1, n + 1):
                if i not in visited:
                    visited.add(i)  # action
                    # print(visited)
                    helper(i)  # Recursion
                    visited.remove(i)  # backtrack

        helper(1)
        return self.count


# backtracking Solution
# TC =O(n!)
# Space complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
