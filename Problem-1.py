# Time Complexity :average O(valid combinations)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def __init__(self):
        # global variable count
        self.count =0
    def backtrack(self,N,index,Narr):
        # if all N used add count
        if index > N:
            self.count +=1
        # loop from 1 to N+1 the +1 is an ancor
        for i in range(1,N+1):
            # if we can put index in this place in arrangment put it and back track
            if (not Narr[i]) and (index%i ==0 or i% index == 0):
                Narr[i] = True
                self.backtrack(N,index+1,Narr)
                # remove index from position i
                Narr[i] = False
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        #if place is used or not
        Narr = [False for i in range (N+1)]
        #backtrack given the number of places in arrangment index = 1 and the array to save place
        self.backtrack(N,1,Narr)
        return self.count
        