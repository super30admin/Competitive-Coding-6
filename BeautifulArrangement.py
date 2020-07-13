---------------------------------Beautiful Arrangement-------------------------------------
# Time Complexity : O(N!)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I have used backtracking approach where the position is defined by index and looping through the element of array, I will check 
#  whether the position is divisible by that number or not/number is divisible by the position or not. If yes I will add the number to that position 
# When my temp array length is equal to the len of nums then I will increment the count by 1. Once I iterate all the positions,
# return count

class Solution:
    def countArrangement(self, N: int) -> int:
        if N == 0:
            return 0
        
        nums = [(i+1) for i in range(N)]
        #[1,2,3] N = 3
        
        def backtrack(nums, temp, index):
            # base Case
            
            if not nums:
                self.count +=1
            #Logic
            
            for i in range(len(nums)):
                if (index+1)%nums[i] == 0 or nums[i]%(index+1) == 0:
                    #action
                    temp.append(nums[i])
                    # Recurse
                    backtrack(nums[:i]+nums[i+1:], temp, index+1)
                    
                    # Backtrack
                    
                    temp.pop()
                
                
                
            
            
        self.count = 0
        backtrack(nums, [], 0)
        return self.count
        