#Time Complexity: O(n!)
#Space Complexity: O(n)

class Solution:
    visited = []
    count = 0
    def countArrangement(self, n: int) -> int:
        self.visited = [0 for i in range(n)]
        self.count = 0
        
        self.helper(n,1)
        
        return self.count
        
    def helper(self,n,idx):
        
        if idx>n:
            self.count+=1
            return 
        
        for i in range(1,n+1):
            if self.visited[i-1]==0 and ((idx%i == 0) or (i%idx==0)):
                self.visited[i-1] = 1
                self.helper(n,idx+1)
                self.visited[i-1] = 0