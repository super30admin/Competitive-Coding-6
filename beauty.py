# // Time Complexity :O(n!)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we recursivley backtrack by trying toput each elem at a possible indx according to the beautfication conditions and if its not occupied. To keep track of visited indexes,
# we use a hashset
class Solution(object):
    count=0
    def beauty(self,elem,idx):
        if(elem%idx==0 or idx%elem==0):
            return True
        return False

    def helper(self,n,pos,ss):
        
            # base
        if(pos>=n+1):
            self.count+=1
            return
            # logic
        else:
            for i in range(1,n+1):
                if (i not in ss and self.beauty(i,pos)):
                        # action
                    ss.add(i)
                        # recurse
                    self.helper(n,pos+1,ss)
                        # backtrack
                    ss.remove(i)

    def countArrangement(self, n):
        """
        :type n: int
        :rtype: int
        """
       
        self.helper(n,1,set())
        return self.count