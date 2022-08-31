#  Time Complexity : O(k) where k is the number of valid permutations
#  Space Complexity : O(n) length of array
#  Did this code successfully run on Leetcode :yes 

class Solution:   
    def countArrangement(self, n: int) -> int:
        visited=[False]*(n+1)
        self.ct=0
    
        def helper(visited, pos, n):
                if pos==n+1:
                    self.ct=self.ct+1
                    return
                for i in range(1, n+1):
                    if visited[i]==False and (pos % i==0 or i % pos==0):
                        #make visited true if it satisfies the beautiful arrangement condition and is not already true
                        #action
                        visited[i]=True
                        #recurse
                        helper(visited, pos+1, n)
                        #backtrack
                        visited[i]=False 
        if n<=0:
            return
        helper(visited, 1, n)
        return self.ct