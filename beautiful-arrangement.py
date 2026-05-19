# Time Complexity: O(n!)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def countArrangement(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        self.res=0
        visited=[False]*(n+1)

        def helper(pos):
            #base
            if pos>n:
                self.res+=1
                return

            #logic
            for i in range(1,n+1):
                if not visited[i] and (pos%i==0 or i%pos==0):
                    visited[i]=True
                    helper(pos+1)
                    visited[i]=False
            
        helper(1)
        return self.res
