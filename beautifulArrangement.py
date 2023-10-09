# Time Complexity: O(valid permutations)
# Space Complexity: O(valid nodes visited)

class Solution(object):
    def countArrangement(self, n):
        """
        :type n: int
        :rtype: int
        """
        nums = list(range(1,n+1))
        self.count=0

        def helper(idx):
        #base
            if idx == n:
                self.count +=1


        #logic
            for i in range (idx,n):
                nums[idx], nums[i] = nums[i], nums[idx]
                if (nums[idx]%(idx+1) == 0) or ((idx+1) % nums[idx] == 0):
                    helper(idx+1)

            #backtrack
                nums[idx], nums[i] = nums[i], nums[idx]

        helper(0)
        return self.count
