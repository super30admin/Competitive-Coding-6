# // Time Complexity : O(n!)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

class Solution:
    def countArrangement(self, n: int) -> int:
        # helper function
        def helper(pos, used):
            # base
            if pos > n:
                return 1
            # logic
            total = 0
            for candidate in range(1, n+1):
                if not used[candidate] and (pos % candidate == 0 or candidate % pos == 0):
                    used[candidate] = True
                    # recursive call
                    total += helper(pos + 1, used)
                    # backtracked
                    used[candidate] = False
            
            return total
        # call 
        used = [False for _ in range(n+1)] 
        return helper(1, used)