# Apporach: Backtracking

# At every point we need to choose that which n numbers are we going to add in the list that is not going to break the given rules/conditions and go down that path. 

# Here one of the important data stucture we will maintain is hashsets. Reason being we dont want to add the same number twice inside the list. If it was added before we wont add it again. Hashset checks for any number in O(1) time complexity. So that saves the overhead here.

# Here we also put a condition on the recursion. If its follows the following two conditions, then and then only we will be moving forward to that path:
# 1) Number we want to add is not in the hashset
# 2) If adding that number follows the given conditions.

# Time complexity: O(n!)
# Space complexity: O(n)

# Here time complexity is in factorial due to the following understanding.
# We have n places to add first element. N-1 places to add second element. N-2 placed to add third element and so on.
# That means n*(n-1)*(n-2)....1 = n!

class Solution:
    def countArrangement(self, N: int) -> int:
        self.count = 0
        self.hset = set()
        if N == 0:
            return self.count
        
        self.backtrack(N)
        return self.count
    
    def backtrack(self, N):
        # Base
        if len(self.hset) == N:
            self.count += 1
            return
        
        # Logic
        for i in range(1, N+1):
            if i not in self.hset and (self.isSafe(i)):
                
                # Action
                self.hset.add(i)
                
                # Recurse
                self.backtrack(N)
                
                # Backtrack
                self.hset.discard(i)
                
    def isSafe(self, i):
        n = len(self.hset)
        if (n + 1) % i == 0 or i % (n + 1) == 0:
            return True
        return False