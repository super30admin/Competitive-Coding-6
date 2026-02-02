class Solution:
    def __init__(self):
        self.visited=[]
        self.count=0
    def countArrangement(self, n: int) -> int:
        self.visited=[False]*(n+1)
        self.helper(n,1)
        return self.count
    
    def helper(self,n,pos):
        #basecase
        if pos>n:
            self.count+=1
            return
        
        for i in range(1,n+1):
            if self.visited[i]==False and (pos%i==0 or i%pos==0):
                self.visited[i]=True
                self.helper(n,pos+1)
                self.visited[i]=False