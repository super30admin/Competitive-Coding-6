class Solution:
    def __init__(self):
        self.visited=[]
        self.count=0

    def countArrangement(self, n: int) -> int:
        self.visited=[False]*(n+1)
        self.helper(1,n)
        return self.count
    
    def helper(self,val,n):
        if val>n:
            self.count+=1
            return 

        for i in range(1,n+1):
            if not self.visited[i] and (i%val==0 or val%i==0):
                self.visited[i]=True
                self.helper(val+1,n)
                self.visited[i]=False

        