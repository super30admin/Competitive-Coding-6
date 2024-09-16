"""
Time Complexity : O(m) where m is no. of valid permuations
Space Complexity : O(n) where n is depth of the tree or the number given
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    count = 0
    def countArrangement(self, n: int) -> int:
        self.length = n
        # Initialize visited list to keep track of no. that we've found that 
        # permutation
        visited = [0 for _ in range(n+1)]
        self.permute(1, visited)
        return self.count
    # Function to go through all the nos and find permuations if they satisfy the         # condition
    def permute(self, idx, visited):
        if idx > self.length:
            self.count += 1
            return
        for i in range(1, len(visited)):
            if visited[i] == 0 and (idx%i == 0 or i%idx == 0):
                visited[i] = 1
                self.permute(idx + 1, visited)
                visited[i] = 0
        return
    