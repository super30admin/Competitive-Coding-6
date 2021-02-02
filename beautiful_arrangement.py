# Time - O(k) where k is the number of permutations
# Space - O(N) since use a set
class Solution:

    def countArrangement(self, n: int) -> int:
     #base case
        if not n:
            return 0
        
        self.visited = set()
        
        self.count = 0
        
        # start from 1 to N numbers
        self.backtrack(1, n)
        
        return self.count



    def backtrack(self, i, n):
        #base
        # as given in question
        
        if len(self.visited) % i != 0 and i % len( self.visited) != 0:
            return 
        
        if len(self.visited) == n:
            self.count += 1

         #logic
        # i ranges from 1 to N
        for i in range(1, n+1):
            if i not in self.visited:
                 #action
                self.visited.add(i)
                 #recurse
                self.backtrack(i,n)
                 #backtrack
                self.visited.remove(i)
        