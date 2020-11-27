#Using backtracking to solve this problem
#Time complexity: O(number of permutations)
#Space complexity: O(n)
class Solution:
    def __init__(self):
        self.result = list()
        self.count = 0
        
    def countArrangement(self, N: int) -> int:
        d = dict()
        for i in range(1,N+1):
            d[i] = False
        self.helper(d,1,N)
        return self.count
        
    def validate(self,index,number):
        if index%number==0 or number%index==0:
            return True
        else:
            return False
        
    def helper(self,visited,index,N):
        if index == N+1:
            self.count = self.count + 1
            return
        for i in range(1,N+1):
            if not visited[i] and self.validate(index, i):
                visited[i]=True
                self.helper(visited,index+1,N)
                visited[i]=False
s = Solution()
s.countArrangement(2)
print(s.count)