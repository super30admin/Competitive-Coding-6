"""
// Time Complexity : o(n!)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

class Solution:
    def helper(self,i,N):
        if len(self.vis) % i != 0 and i % len(self.vis): #if invalid at any point, return
            return
            
        if len(self.vis) == N:# if reached till end, valid arrangement, increment count
            self.count += 1
            return
        
        for i in range(1,N+1):
            if i not in self.vis:
                self.vis.add(i)
                self.helper(i,N)
                self.vis.remove(i)
        
    def countArrangement(self, N: int) -> int:
        self.vis = set() #to keep track of numbers already visited at each step
        self.count = 0
        
        self.helper(1,N)
        return self.count
        