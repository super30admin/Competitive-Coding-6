# // Time Complexity : O(k) where k stands for number of beautiful arrangements
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

class Solution:
    def __init__(self):
        self.count = 0
        
    def backtrack(self,arr,temp,index):
        if len(temp) == len(arr): self.count += 1
        # print(self.count,temp)
        for i in range(len(arr)):
            pos = index+1
            if not self.visited[i] and (pos % arr[i] == 0 or arr[i] % pos == 0):
                # print(index,temp,self.visited)
                self.visited[i] = True
                temp.append(arr[i])
                self.backtrack(arr,temp,index+1)
                self.visited[i] = False
                temp.pop()
            
    def countArrangement(self, n: int) -> int:
        self.visited = [False for _ in range(n)]
        arr = [i for i in range(1,n+1)]
        
        self.backtrack(arr,[],0)
        return self.count
        