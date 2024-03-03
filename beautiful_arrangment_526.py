class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        self.backtrack(n, 1, [])
        return self.count

    def backtrack(self, N, idx, visited):
        print(N)
        print(idx)
        print(visited)
        print("___")
        if len(visited) == N:
            print(visited)
            self.count += 1
            return

        for i in range(1, N + 1):
            print("###")
            print(i)
            if i not in visited and (i % idx == 0 or idx % i == 0):
                visited.append(i)
                self.backtrack(N, idx + 1, visited)
                visited.pop()


d = Solution()
print(d.countArrangement(3))
