#Time complexity: O(N!) as it is along the router of tracking a permiutation which is n! and then check the condition which is provided perm[i] divisible by i and vice versa
#Space complexity: O(n) recursion stack depth and visit set.

# The intuition is simple, to calculate the permutation by backtracking and only chose the ones that satisfy the condition and increment the result count

class Solution:
    def countArrangement(self, n: int) -> int:
        self.result = 0
        self.helper(n, 1, set())
        return self.result

    def helper(self, n, pos, visit):
        if pos > n:
            self.result += 1
            return

        for i in range(1, n + 1):
            if i not in visit and (pos % i == 0 or i % pos == 0):
                visit.add(i)
                self.helper(n, pos + 1, visit)
                visit.remove(i)