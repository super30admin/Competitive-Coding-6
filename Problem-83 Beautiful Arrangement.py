# 526. Beautiful Arrangement
# https://leetcode.com/problems/beautiful-arrangement/

class Solution:
    def __init__(self):
        self.beautifulArrCount = 0
    
    def _helper(self, nums, n, idx, curpath):
        # Base
        if idx == n:
            return
        
        if not self.isBeautiful(curpath):
                return
        else:
            if len(curpath) == n :
                self.beautifulArrCount += 1
                
        for i in range(n):
            # Action
            if nums[i] in curpath:
                continue
            else:
                curpath.append(nums[i])
            
            # Recursion
            self._helper(nums, n, i, curpath)
            
            # Backtrack
            curpath.pop()
    
    def isBeautiful(self, nums):
        if not nums:
            return True
        
        res = False

        for idx, i in enumerate(nums):
            if i % (idx+1) == 0 or (idx+1) % i == 0:
                res = True
            else:
                return False
            
        return res
    
    def countArrangement(self, n: int) -> int:
        nums = [i+1 for i in range(n)]
        
        self._helper(nums, n, 0, [])
        return self.beautifulArrCount       
