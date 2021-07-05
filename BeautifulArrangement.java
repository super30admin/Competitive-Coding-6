class Solution:
    def countArrangement(self, N: int) -> int:
        global count
        count=0
        self.helper(N,1,[False for i in range(N+2)])
        return count
        
        
    def helper(self,N,curr,visitArray):
        global count
        #base
        if curr>N:
            count+=1
        #logic
        for i  in range(1,N+1):
            if(visitArray[i]==False and (curr%i==0 or i%curr==0)):
                visitArray[i]=True
                self.helper(N,curr+1,visitArray)
                visitArray[i]=False
                
                
    #Time complexity: O(k), k is valid permutations
    #Space complexity: O(n), size of the array
                
        
        
        