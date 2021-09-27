#Time Complexity : O(2^n)
#Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No




class Solution:
    hashset = set()
    count = 0
    def backtrack(self, i, hashset, n):
        if i>n and len(hashset) == 0:
            Solution.count += 1
        for x in range(1, n+1):
            if x in hashset:
                if x%i == 0 or i%x == 0:
                    hashset.remove(x)
                    self.backtrack(i+1, hashset, n)
                    hashset.add(x)
                    
    def countArrangement(self, n: int) -> int:
        if n == 1:
            return 1
        Solution.hashset = set()
        for i in range(1, n+1):
            Solution.hashset.add(i)
        Solution.count = 0
        self.backtrack(1, Solution.hashset, n)
        return Solution.count
        