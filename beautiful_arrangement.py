# Time Complexity: O(n!)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The total number of beautifull arrangements is gotten by creating a visited array to keep 
a track of the number alraedy visited searching the whole space of the tree.
"""

class Solution:
    def countArrangement(self, n: int) -> int:
        self.n = n
        self.answer = 0
        self.visited = [False for i in range(self.n+1)]
        self.dowork(1)

        return self.answer

    def dowork(self, position):
        if position > self.n:
            self.answer += 1
        for i in range(1, self.n +1):
            if self.visited[i] == False and (position%i==0 or i%position==0):
                self.visited[i] = True
                self.dowork(position + 1)
                self.visited[i]= False