# Space Complexity: O(n)
# Time Complexity: n!
class Solution:
    def countArrangement(self, n: int) -> int:

        self.ans = 0
        def dfs(i, s):
            if i >= n+1:
                self.ans+=1
                return 

            for j in range(1, n+1): 
                if ((j % i == 0) or (i % j == 0)) and j not in s: 
                    s.add(j)
                    dfs(i+1, s)
                    s.discard(j)

        dfs(1, set())
        return self.ans
        



        
