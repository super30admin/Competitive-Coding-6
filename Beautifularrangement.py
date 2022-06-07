#Time Complexity: O(n!)
#Space Complexity: O(n)
class Solution:
    count = 0
    visitedList = []
    def countArrangement(self, n: int) -> int:
        self.count = 0
        self.visitedList = [0 for i in range(n)]
        
        self.helper(n,1)
        
        return self.count
        
        
    def helper(self,n,idx):
        
        if idx>n:
            self.count += 1
            return 
        
        for i in range(1,n+1):
            
            if self.visitedList[i-1] == 0 and ((i%idx == 0) or (idx%i == 0)):
                self.visitedList[i-1] = 1
                self.helper(n,idx+1)
                self.visitedList[i-1] = 0
                
                
                
        
        