# Time Complexity :average O(valid combinations)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def __init__(self):
        
        self.count =0
    def backtrack(self,N,index,Narr):
        
        if index > N:
            self.count +=1
        
        for i in range(1,N+1):
            
            if (not Narr[i]) and (index%i ==0 or i% index == 0):
                Narr[i] = True
                self.backtrack(N,index+1,Narr)
                
                Narr[i] = False
    def countArrangement(self, N):
       
        
        Narr = [False for i in range (N+1)]
        
        self.backtrack(N,1,Narr)
        return self.count