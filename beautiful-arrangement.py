# Time Complexity: 0(k) - k is number of beautiful arrangements
# Space Complexity: O(n) - Size of array
# Approach: Generate permutations of the numbers from 1->N, at every step, check if the condition for the index % num matches.
class Solution(object):
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        nums = []
        for i in range(N):
            nums.append(i+1)
        res = [0]
        
        def backtrack(start):
            # Base
            if start == N:
                res[0] += 1
                return
            
            # Logic
            for i in range(start, N):
                if (start+1) % nums[i] == 0 or nums[i] % (start+1) == 0:
                    # Swap nums to skip the current number in the next recursive call
                    nums[start], nums[i] = nums[i], nums[start]
                    backtrack(start + 1)
                    # Backtrack
                    nums[i], nums[start] = nums[start], nums[i]
            
        backtrack(0)
        return res[0]