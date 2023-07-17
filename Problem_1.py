"""
Problem : 1

Time Complexity : O(n^2)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Calling out the helper(recursive) function starting from the zeroth index and an empty path variable which will store the possible combination of
n integers, starting from 1 till N+1, as first index is considered 1 instead of 0, checking  if the number already exists in the path, also 
checking if either of the index and the number are divisible by each other, if yes, then adding the number to path, as a valid combination 
and calling helper function on next index, which also checks for valid combinations from 1 to N+1, ensuring all the possible combination
if the length of the path variable matches N, increasing the counter, at the end, returning the count

"""

# Beautiful Arrangement

# Approach - 1

class Solution(object):
    def __init__(self):
        self.count=0
    def countArrangement(self, n):
        """
        :type n: int
        :rtype: int
        """
        self.helper(0,n,[])
        return self.count
    def helper(self,pivot,n,path):
        # base
        if len(path)==n:
            self.count+=1
            return
        # logic
        for i in range(1,n+1):
            if i not in path:
                if i%(len(path)+1)==0 or (len(path)+1)%i==0:
                    # action
                    path.append(i)
                    # recurse
                    self.helper(i+1,n,path)
                    # backtrack
                    path.pop()


# Approach - 2

class Solution(object):
    def __init__(self):
        self.visited=set()
        self.count=0
    def countArrangement(self, n):
        """
        :type n: int
        :rtype: int
        """

        self.helper(0,n)
        return self.count
    def helper(self,pivot,n):

        # base
        if len(self.visited)==n:
            self.count+=1
            return

        # logic
        for i in range(1,n+1):
            if i not in self.visited:
                size=len(self.visited)
                if i%(size+1)==0 or (size+1)%i==0:
                    self.visited.add(i)
                    self.helper(i+1,n)
                    self.visited.remove(i)