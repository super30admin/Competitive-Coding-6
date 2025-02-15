#space: O(n)
#TimeL O (height of recursive stack)
class Solution:
    def countArrangement(self, n: int) -> int:
        self.final= 0
        self.recurse(n,set())
        return self.final
    
    def recurse(self,n,path):
        
        if len(path) > n :
            return
        if (len(path) == n):
            self.final+=1
            return

        for i in range(1,n+1):
            if i % (len(path)+1) ==0 or (len(path)+1) % i ==0:
                if i not in path:
                    path.add(i)
                    self.recurse(n,path)
                    path.remove(i)
       
