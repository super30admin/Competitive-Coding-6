# Time Complexity : O(p), where p is the number of valid permutations
# Space Complexity : O(n), where n is the given input N
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach

# The approach keeps track of the valid permutations using a Boolean array, where
# the index represent a number. For every index, a valid permutation is formed on
# the basis of the rules provided. If the permutation is formed, the result is incremented.
class Solution(object):
    def __init__(self):
        self.count = 0

    def countArrangement(self, N):
        # edge case
        if N <= 0:
            return 0
        # array init
        nums = [False] * (N + 1)
        # initial recursive call
        self.helper(nums, N, 1)
        return self.count

    def helper(self, nums, N, idx):
        # base case
        if idx > N:
            self.count += 1
            # logic
        for i in range(1, N + 1):
            if not nums[i] and (idx % i == 0 or i % idx == 0):
                # action
                nums[i] = True
                # recurse
                self.helper(nums, N, idx + 1)
                # backtrack
                nums[i] = False
                
