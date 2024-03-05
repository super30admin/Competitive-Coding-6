# Time complexity is O(n!)
# Space complexity is O(n)

class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        hashSet = set()
        self.helper(n, 1, hashSet)
        return self.count

    def helper(self, n, idx, hashSet):
        if len(hashSet) == n:
            self.count += 1
            return

        for i in range(1, n+1):
            if i not in hashSet and (i % idx == 0 or idx % i == 0):
                hashSet.add(i)
                self.helper(n, idx + 1, hashSet)
                hashSet.remove(i)
