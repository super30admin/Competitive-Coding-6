'''
Time complexity - O(n * 2^n) as work done per iteration is n, total number of mask states possible is 2^n 
Space complexity - O(2^n) for memoization + O(n) for recursion stack
'''

class Solution:
    def countArrangement(self, n: int) -> int:

        memo = {}

        def solve(mask):
            nonlocal memo
            set_bits = mask.bit_count()
            if set_bits == n:
                return 1

            if mask in memo:
                return memo[mask]

            total = 0

            for i in range(1, n + 1):
                current = 1 << (i - 1)
                if not (mask & current):
                    if (set_bits+1) % i == 0 or i % (set_bits+1) == 0:
                        total += solve(mask | (1 << (i - 1)))

            memo[mask] = total
            return total

        return solve(0)
