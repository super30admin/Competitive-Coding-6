# TC : O(k)
# SC : O(n)

class Solution:
    def countArrangement(self, n: int) -> int:
        nums = list(range(1, n+1))
        self.count = 0

        def backtrack(pos):
            if pos == n:
                self.count += 1

            for i in range(pos, n):
                nums[pos], nums[i] = nums[i], nums[pos]
                if nums[pos] % (pos+1) == 0 or (pos+1) % nums[pos] == 0:
                    backtrack(pos+1)
                nums[pos], nums[i] = nums[i], nums[pos]

        backtrack(0)

        return self.count
