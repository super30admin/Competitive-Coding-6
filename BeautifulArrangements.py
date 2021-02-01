class Solution:
    def countArrangement(self, n: int) -> int:
        # Time Complexity: O(n!)
        # Space Complexity: O(n)
        nums = []
        for i in range(0,n):
            nums.append(i+1)
            
            
        c = 0
    
        def helper(nums, index, visited):
            if(len(nums)+1==index):
                nonlocal c
                c+=1
                return

            for i in range(0,len(nums)):
                if(nums[i]%index==0 or index%nums[i]==0) and not(nums[i] in visited):
                    visited.add(nums[i])
                    helper(nums, index+1, visited) # 2, [1]
                    visited.remove(nums[i])


        helper(nums,1,set())
        return c
