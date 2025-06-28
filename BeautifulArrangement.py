class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        nums = [0] * n
        self.helper(nums, n, 1)
        return self.count
    
    def helper(self, nums, n, value):
        if value > n:
            self.count += 1
            return
        for i in range(n):
            if nums[i] == 0 and (value % (i+1) == 0 or (i+1) % value == 0):
                nums[i] = value
                self.helper(nums, n, value + 1)
                nums[i] = 0