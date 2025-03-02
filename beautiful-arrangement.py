# TC : O(n!)
# SC : O(3n) = O(n)  - n for the set, n for the list, n for the recursion stack

class Solution(object):
    def countArrangement(self, n):
        """
        :type n: int
        :rtype: int
        """

        self.count = 0
        self.lst = []
        for i in range(1, n + 1):
            self.lst.append(i)

        self.helper(set(), 0, n)
        return self.count

    def helper(self, pathSet, index, n):

        # base condition
        if index == n:
            self.count += 1
            return

        for i in range(0, n):
            if self.lst[i] not in pathSet:
                if (index + 1) % self.lst[i] == 0 or self.lst[i] % (index + 1) == 0:
                    pathSet.add(self.lst[i])

                    # recurse
                    self.helper(pathSet, index + 1, n)

                    # backtrack
                    pathSet.remove(self.lst[i])





