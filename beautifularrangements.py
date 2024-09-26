#Time complexity: O(n); n= valid permutations count
#Space complexity: O(n)
class Solution:
    def countArrangement(self, n: int) -> int:
        nums = [i+1 for i in range(n)]
        self.cnt = 0
        self.helper(nums, 1, n)
        return self.cnt
    def helper(self, nums, k, n):
        if n+1 == k:
            self.cnt += 1   
            return
   
        for i in range(len(nums)):
            if nums[i] % (k) == 0 or (k) % nums[i] == 0:
                self.helper(nums[:i]+nums[i+1:], k+1, n)
         
            
        
