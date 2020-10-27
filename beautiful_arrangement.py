# O(K * K) TIME AND O(K) WHERE K IS VALID PERMUTAIONS

class Solution:
    def __init__(self):
        self.count = 0
    def countArrangement(self, N: int) -> int:
        visited = [False for _ in range(N+1)]
        self.findValidPerm(N,1,visited)
        return self.count
    def findValidPerm(self,N,curr,visited):
        if curr > N:
            self.count += 1
            return
        for i in range(1,N+1):
            if not visited[i] and (i % curr == 0 or curr % i == 0):
                visited[i] = True
                self.findValidPerm(N,curr + 1,visited)
                visited[i] = False