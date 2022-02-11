'''
TC: O(2^k)
SC: O(n)
'''
class Solution:
    def __init__(self):
        self.res = 0
        self.n = None
    
    def helper(self, visited, rem, nxt):
        # base
        if rem == 0:
            self.res += 1
        
        # logic
        for idx in range(1, self.n + 1):
            if not visited[idx]:
                if (nxt % idx) == 0 or (idx % nxt) == 0:
                    visited[idx] = True
                    self.helper(visited, rem - 1, nxt + 1)
                    visited[idx] = False
    
    def countArrangement(self, n: int) -> int:
        if not n:
            return 0
        
        self.n = n
        visited = [False for i in range(n+1)]
        self.helper(visited, n, 1)
        
        return self.res
        
        
        # [1,2,3]
        
        