# Time O(n!)
# Space O(n)
class Solution:
    def __init__(self):
        self.count = 0
    def countArrangement(self, n: int) -> int:
        choices = [i for i in range(1, n+1)]
        self.dfs(n, 0, choices)
        return self.count
    
    def dfs(self, n: int, pos: int, choices: List[int]):
        # Base
        if pos == n: self.count += 1

        for ch in choices:
            if ch > 0:
                if (pos+1) % ch == 0 or ch % (pos+1) == 0: 
                    choices[ch-1] = -ch
                    self.dfs(n, pos + 1, choices)
                    choices[ch-1] = ch