# Approach:
# - We generate permutations of [1, 2, ..., n] using backtracking.
# - At each index (1-based), we place a number that satisfies:
#     num % pos == 0 or pos % num == 0
# - We swap to generate permutations in-place and backtrack after each call.

# Time Complexity: O(n!) worst-case (but pruned by constraints)
# Space Complexity: O(n) due to recursion stack and in-place nums list

class Solution:
    def countArrangement(self, n: int) -> int:
        if n <= 0:
            return 0
        nums = list(range(1, n+1))
        def backtrack(idx):
            if idx == n:
                return 1
            total = 0
            for i in range(idx, n):
                nums[i], nums[idx] = nums[idx], nums[i]
                if nums[idx] % (idx + 1) == 0 or (idx + 1) % nums[idx] == 0:
                    total += backtrack(idx+1)
                nums[i], nums[idx] = nums[idx], nums[i]
            return total
        return backtrack(0)

def main():
    sol = Solution()
    for n in range(1, 5):  # test for n = 1 to 4 macha 🚀
        count = sol.countArrangement(n)
        print(f"n = {n} → Beautiful Arrangements = {count}")


if __name__ == "__main__":
    main()