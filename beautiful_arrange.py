# Backtracking with for loop 
# Time: O(k).k refered to the number of valid permutation
# space: O(N) visited array of size nis used. The depth of recursion tree will also go upto n. Here, n refers to the given integer n.
class Solution:
    def countArrangement(self, n: int) -> int:
        #base case
        if not n:
            return 0
        self.visited = set()
        self.count = 0
        self.backtrack(1, n)
        return self.count
        
        
        
    def backtrack(self, i,n):
        #base
        if len(self.visited) % i != 0 and i % len( self.visited) != 0:
            return 
        if len(self.visited) == n:
            self.count += 1

        #logic
        # since I need to travel from 1 in an array
        for i in range(1, n+1):
            if i not in  self.visited:
                #action
                self.visited.add(i)
                #recurse
                self.backtrack(i,n)
                #backtrack
                self.visited.remove(i)
