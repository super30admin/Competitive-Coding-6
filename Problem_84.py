# TC : O(M) => Valid permutations
# SC : O(N)

class Solution:
    def countArrangement(self, n: int) -> int:
        def backtrack(pos):
            if pos > n:
                self.count += 1
            for i in range(1, n + 1):
                if not self.visited[i] and (pos % i == 0 or i % pos == 0):
                    print(i, pos)
                    self.visited[i] = True
                    backtrack(pos + 1)
                    self.visited[i] = False

        self.count = 0
        self.visited = [False for i in range(n+1)]
        backtrack(1)
        return self.count


