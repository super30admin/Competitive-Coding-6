# Time: O(n!): As we generate all permutaions from 1 - n and after we choose a number we cannont choose it again so we have n choices then n-1, then n-2 and so on.
# Space: O(n): We are using a visited set to keep track of the numbers we have used so far and the maximum size of the visited set is n when we have used all the numbers from 1 to n.

# Question: Asks us to count the number of beautiful arrangements that can be formed with numbers from 1 to n and a beautiful arrangement is defined as an arrangement where for every position i (1-indexed), either the number at that position is divisible by i or i is divisible by the number at that position.

# So for this approach we use backtracking to generate all possible permutations of numbers from 1-n.
# We also use a visited set to keep track of the numbers used so far and we only generate the next permutation if the current number is not in the visited set.
#        it satisfies the condition of being a beautiful arrangement.

class Solution:
    def countArrangement(self, n: int) -> int:
        visited = set()
        self.res = 0
        self.helper(1,n,visited)
        return self.res
    def helper(self,idx,n,visited):
        if idx == n+1:
            self.res += 1
            return
        for i in range(1,n+1):
            if i not in visited:
                visited.add(i)
                if i % idx == 0 or idx % i == 0: 
                    self.helper(idx+1,n,visited)
                visited.remove(i)