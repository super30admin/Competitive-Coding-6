class Solution:
    def countArrangement(self,n):
        self.count=0
        visited=[False]*(n+1)

        def backtrack(position):
            if position >n:
                self.count +=1
                return
            for i in range(1,n+1):
                if not visited[i] and (i % position==0 or position % i ==0):
                    visited[i]=True
                    backtrack(position+1)
                    visited[i]=False
        backtrack(1)
        return self.count
sol=Solution()
print(sol.countArrangement(2))
print(sol.countArrangement(1))