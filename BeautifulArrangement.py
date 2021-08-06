# Time complexity: O(N)
# Space complexity: O(N)
class Solution:
    def countArrangement(self, N: int) -> int:

        def backtrack(N,pos,visit):
            if pos>N:
                self.count+=1

            for i in range(1,N+1):
                if (not visit[i] and (pos%i==0 or i%pos==0)):
                    visit[i] = True
                    backtrack(N,pos+1,visit)
                    visit[i]=False




        if N ==0:
            return 0
        visit = [False for i in range(N+1)]
        self.count=0
        backtrack(N,1,visit)
        return self.count