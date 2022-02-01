# Time Complexity: O(n!)
# Space Complexity: O(n)
class Solution(object):
    counter = 0
    def countArrangement(self, n):
        """
        :type n: int
        :rtype: int
        """
        def helper(visited, index):
            # Base
            if index > n: 
                self.counter+=1
            # Logic
            for i in range(1, n+1):
                if not visited[i] and (i%index == 0 or index%i == 0):
                    # action
                    visited[i] = True
                    #recurse
                    helper(visited, index+1)
                    # backtrack
                    visited[i] = False
                    
        
        visited = [False for i in range(n+1)]
        helper(visited, 1)
        return self.counter