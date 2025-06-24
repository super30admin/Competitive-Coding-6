"""
Check by placing unused numbers at position `i`
Check if they satisfy the beautiful condition
Apply backtracking to try all valid configurations
"""
"""
Time Complexity: O(n!) (all permutations), but pruned by constraints
Space Complexity: O(n) recursion stack + visited array
"""


class beautifulArrangement:
    def countArrangement(self, n: int) -> int:
        visited = [False] * (n + 1)
        count = 0

        def backtrack(pos):
            nonlocal count
            if pos > n:
                count += 1
                return
            for i in range(1, n + 1):
                if not visited[i] and (i % pos == 0 or pos % i == 0):
                    visited[i] = True
                    backtrack(pos + 1)
                    visited[i] = False

        backtrack(1)
        return count
    
if __name__ == "__main__":
    obj = beautifulArrangement()
    print(obj.countArrangement(2))
    print(obj.countArrangement(3))
