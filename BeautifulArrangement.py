class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        self.nums = [i for i in range(1, n+1)]

        def backtrack(curr, path):
            # base
            if curr > n:
                self.count += 1
                return

            # main logic
            for i in range(1, n+1):
                if i not in path and (i % curr == 0 or curr % i == 0):
                    path.append(i)
                    backtrack(curr+1, path)
                    path.pop()

        backtrack(1, [])
        return self.count
