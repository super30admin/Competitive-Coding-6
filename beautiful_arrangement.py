# Time Complexity :
# O(K) - where K is the number of beautiful arrangements

# Space Complexity :
# O(N) - maximum depth of the recursion

# Did this code successfully run on Leetcode :
#Yes

#We try to place every number at every position, then try to place the rest of the numbers from the next position onwards
#We use a visited array to indicate the current number has already been placed and what if the other numbers can be placed at the current given position

class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        visited = [False] * (n+1)
        self.calculate(n, 1,visited)
        return self.count

    def calculate(self,n,pos,visited):
        if pos > n:
            self.count += 1
            return
        for i in range(1,n+1):# 
            if ( not visited[i] and (pos % i == 0 or i % pos == 0)) :
                visited[i] = True
                self.calculate(n, pos + 1,visited)
                visited[i] = False
