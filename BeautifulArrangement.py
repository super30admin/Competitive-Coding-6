# Time Complexity: O(n!)
# Space Complexity: O(n)
# Does this code run on Leetcode: Yes
# Did you face any problems while coding this: No

class Solution:
    def countArrangement(self, n: int) -> int:
        visited = [0]* (n+1)
        self.count = 0
        
        def backtrack(pos):
            if pos > n:
                self.count += 1
                return
            
            for i in range(1, n+1):
                if visited[i] == 0 and (i % pos == 0 or pos % i == 0):
                    visited[i] = 1
                    backtrack(pos + 1)
                    visited[i] = 0
        backtrack(1)
        return self.count