def beautifulArrangement(nums):
    # Time Complexity: O(n!)
    # Space Complexity: O(n)
    if(len(nums)==0):
        return 0

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
