# Time Complexity: O(n!)
# Space Complexity: O(n) (for both height of the tree and hashset)
class Solution:
    def __init__(self):
        self.count = 0
        self.h = set()
        self.result = []
    def countArrangement(self, n: int) -> int:
        def helper(n,level,path):
            # Base
            if level == n+1:
                self.count+=1
                self.result.append(list(path))
                return
            
            for i in range(1,n+1):
                if((i % level == 0 or level % i ==0) and i not in self.h):
                    #Action
                    self.h.add(i)
                    path.append(i)
                    #Recurse
                    helper(n,level+1,path)
                    #Backtrack
                    path.pop()
                    self.h.remove(i)
        helper(n,1,[])            
        print(self.result)
        return self.count