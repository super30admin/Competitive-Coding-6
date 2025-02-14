# Time Complexity = O(1n!)
# Space Complexity = O(n)
class Solution:
    def countArrangement(self, n: int) -> int:
        self.visited = [False] * (n + 1)
        self.count = 0
        
        def calculate(n, pos):
            if pos > n:
                self.count += 1
                return 1
            for i in range(1, n + 1):
                if not self.visited[i] and (pos % i == 0 or i % pos == 0):
                    self.visited[i] = True
                    calculate(n, pos + 1)
                    self.visited[i] = False  # Fix: Reset only the current index
        
        calculate(n, 1)
        return self.count