#Time: O(number of beautiful arrangements)
#Space: O(n) for visited array and max depth of recurion
#did the code run successfully? yes
#issues faced: local and global variables
#Approach:
#using dfs explore all potential candidate solutions and backtrack when solution is reached or solution not possible

class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        self.visited = [0 for _ in range(n+1)]

        def backtrack(idx):
            if idx > n:
                self.count+=1
                return
            for digit in range(1, n+1):
                if not self.visited[digit] and (digit % idx == 0 or idx % digit == 0):
                    self.visited[digit] = 1
                    backtrack(idx+1)
                    self.visited[digit] = 0
        backtrack(1)
        return self.count
