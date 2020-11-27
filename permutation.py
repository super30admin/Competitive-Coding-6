#Using backtracking to solve this problem
#Time Complexity: O(n!)
#Space Complexity: O(n)
class Solution:
    def __init__(self):
        self.result = list()
        
    def permute(self, nums):
        if nums is None:
            return
        hset = dict()
        self.helper(nums,[],hset)
        return self.result
        
    def helper(self,nums,temp,hset):
        if len(temp) == len(nums):
            self.result.append(temp.copy())
            return
        for i in range(len(nums)):
            if nums[i] not in hset:
                hset[nums[i]] = 1
                temp.append(nums[i])
                self.helper(nums,temp,hset)
                del hset[nums[i]]
                temp.pop()
                
            
nums = [1,2,3]
s = Solution()
s.permute(nums)
print(s.result)