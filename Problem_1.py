class Solution:
    def __init__(self):
        self.result = 0

    """
    Backtracking approach
    TC - O(n)
    SC - O(n)
    """

    def tee(self, n, i, path):
        if i == n + 1:
            self.result += 1
        for j in range(1, n + 1):
            if j not in path:
                if j % i == 0 or i % j == 0:
                    path.append(j)
                    self.tee(n, i + 1, path)
                    path.pop()

    def countArrangement(self, n: int) -> int:
        if not n:
            return -1
        self.tee(n, 1, [])
        return self.result
