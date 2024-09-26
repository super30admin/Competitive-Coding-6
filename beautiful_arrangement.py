#Time complexity : O(k)

#Space complexity : O(n)ß

class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        self.visited = [False]*(n+1)
        
        def permute(pos):
            if pos>n:
                self.count+=1
            for i in range(1,n+1):
                if not self.visited[i] and (pos%i==0 or i%pos==0):
                    self.visited[i] = True
                    permute(pos+1)
                    self.visited[i] = False
            
        permute(1)
        return self.count
        