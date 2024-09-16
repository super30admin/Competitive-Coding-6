"""
Approach: Recursion with BackTracking
TC O(k) for k valid permutations we will do and O(n) to generate list l
SC O(1) No extra space was used for visited array, O(n) maximum depth of recursion stack
"""

class Solution:
    
    def __init__(self):
        self.result = 0
        
    def countArrangement(self, n: int) -> int:
        l = [i for i in range(1,n+1)]
        
        self.helper(l, 0, [])
        
        return self.result
    
    def helper(self, l, idx, path):
        
        # base
        if len(path) == len(l):
            self.result += 1
        
        
        # logic
        
        for i, item in enumerate(l):
            if item > 0:
                if len(path) == 0 or item % (len(path)+1)== 0 or (len(path)+1) % item == 0:
                    l[i] = -l[i]
                    # action
                    path.append(item)
                    # recurse
                    self.helper(l, i, path)
                    # backtrack
                    path.pop()
                    l[i] = -l[i]
        