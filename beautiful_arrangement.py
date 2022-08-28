# Time Complexity : O(k)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = 0
    def countArrangement(self, n: int) -> int:
        nums = []  
        self.helper(nums, 1, n)
        return self.result
    
    def helper(self, nums, val, n):
        #base
        if len(nums) == n:
            self.result += 1
            return
        
        #logic
        
        for i in range(1, n+1):
            if i not in nums and (val % i == 0 or i % val == 0):
                nums.append(i)
                self.helper(nums, val + 1, n)
                nums.pop()
                
