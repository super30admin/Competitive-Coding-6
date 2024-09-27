# Time Complexity : Exponential
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        visited = set()
        index = 1
        #1 -> N
        self.backtrack(n, index,  visited)
        
        return self.count
    
    def backtrack(self, n, index, visited):
        if index > n:
            self.count += 1
        
        #logic
        for i in range(1, n+1):
            if i not in visited and (i % index == 0 or index % i == 0):
                #action
                visited.add(i)
                #recurse
                self.backtrack(n, index+1, visited)
                #backtrack
                visited.remove(i)
    