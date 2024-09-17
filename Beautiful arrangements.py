# Backtracking
# TC: O(N!)
# SC: O(N)

class Solution:
    def countArrangement(self, N: int) -> int:
        self.count = 0
        self.N = N
        self.hset = set() 
        self.arrangements(1)
        return self.count
    
    def arrangements(self,num):
            if num == self.N+1:
                self.count+=1
                return
            
            for i in range(1, self.N+1):
                if i not in self.hset and min(i%num,num%i)==0: 
                    self.hset.add(i)
                    self.arrangements(num+1)
                    self.hset.remove(i)