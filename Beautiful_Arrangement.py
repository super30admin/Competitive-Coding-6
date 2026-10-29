# Time Complexity : O(N!)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using for loop based recursion. We need a set to check if the number is visited or not.
# We need a helper function where base condition is check length of path == n then return
# In for loop we will check if i is not in set and check if the i is divisible by index or index is divisible by i
# If either of the conditions are not satisfied then we skip that i and check next i
# If either of condition is satisfied we recurse again where index increases by 1 and i starts from 1 again
# When the length of path == n then we resume the call after recurse which is backtrack
# In backtrack i is removed from set and path

class Solution:
    def countArrangement(self, n: int) -> int:
        self.result = []
        helper(n, 1, [], set())
        return len(self.result)

    def helper(self, n, index, path, visited):
        if len(path) == n:
            self.result.append(list(path))
            return
        #logic
        for i in range(1, n+1):
            #action
            if (i%index == 0 or index%i == 0) and i not in visited:
                path.append(i)
                visited.add(i)
                #recurse
                self.helper(n, index+1, path, visited)
                #backtrack
                path.pop()
                visited.remove(i)
