
"""
time: O(N!)
space: O(N)
"""

class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        
        def backtrack( N, idx, temp):
            if len(temp) == N: #if the right combo filled the stack
                self.count += 1
                return
            for i in range(1, N+1):
                if i not in temp and (i%idx == 0 or idx%i==0): #bounding
                    temp.append(i)
                    backtrack(N, idx+1, temp)
                    temp.pop()
        backtrack(n,1,[])
        return self.count