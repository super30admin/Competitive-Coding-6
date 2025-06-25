#Time complexity: O(n!)->we have n-1 choice x n-2...
#Space complexity o(n) for resucrsion stack
# lets say you have n places _ _ _ _ 
# you fix first position and try to find number that fits in 2nd position =and go on but we should not repeat numbers ..so we keep
# visted array
# ----
# We should back track inside  if condition 
# use for loop based recursion then back track 




class Solution:
    def countArrangement(self, n: int) -> int:
        self.ans=0   
        def helper( idx, visted):
            #base
            if idx==n+1:
                # print(idx,self.ans)
                self.ans+=1
                return 
            #logic
            #n%idx or idx%n
            for i in range(1,n+1):
                if (i%idx ==0 or idx%i==0) and (visted[i] is  False):
                    #change visted array
                    visted[i]=True
                    helper(idx+1,visted)
                    #backtrack
                    visted[i]=False
        visted=[False for i in range(n+1)]
        helper(1,visted)
        return self.ans


                

            



