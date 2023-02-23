#Time Complexity :- O(k) where is the number of valid permutations that are used 
#Space Complexity:- O(n) where n is the hash set we create 

class Solution:
    count = 0
    visited = set()
    def countArrangement(self, n: int) -> int:
        self.count = 0
        self.visited = set()
        self.helper(-1, n)
        return self.count
    
    def helper(self, index,  n):
        #base
        if len(self.visited)%index!=0 and index%len(self.visited)!=0:
            return
        if len(self.visited)==n:
            self.count+=1
            return 
        # logic 
        for i in range(1, n+1):
            if i not in self.visited:
                self.visited.add(i)
                self.helper(i, n)
                self.visited.remove(i)


            