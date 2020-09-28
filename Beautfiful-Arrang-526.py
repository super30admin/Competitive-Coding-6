# Time Complexity : O(k) k is valid combination
# Space Complexity : O(n) size of visisted array 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# a little different approach need to add a visisted array because the values can be [1,2] or [2,1]
class Solution(object):
    def backtrack(self, N, idx, visited):
            if idx > N:
                self.count += 1
            
            for i in range(1, N+1):
                if not visited[i] and (idx%i == 0 or i % idx == 0):
                    visited[i] = True
                    self.backtrack(N, idx + 1, visited)
                    visited[i] = False
                    
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        self.count = 0
        
            
        visited= [False for _ in range(N+1)]    
        self.backtrack(N, 1, visited)
        return self.count
