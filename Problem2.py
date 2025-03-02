# Problem 2 : Interview Problem: Beautiful Arrangement
# Time Complexity : O(n!)
# Space Complexity : O(n!)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this :
'''
None
'''
# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def countArrangement(self, n: int) -> int:
        # variable result store all the list of the Beautiful permutation 
        result = []
        # variable result store the current list of the Beautiful permutation 
        currentlist = []
        def helper(n: int, currentlist: List[int]) -> None:
            # global variable result to store all the list of the Beautiful permutation 
            nonlocal result
            # base case
            # if length of the currentlist is equal to n then append the list to the result list
            if n == len(currentlist):
                result.append(currentlist)
                return 
            
            # logic 
            # loop from 1 to n+1
            for i in range(1, n+1):
                # get the last index of the currentlist
                index = len(currentlist)
                # since the list will have unique element so checking if the currentlist already has the element
                # also checking the two condition of the beautiful permutation
                if i not in currentlist and ((index+1) % i == 0 or i % (index+1) == 0):
                    # create deep copy of the list 
                    copyCurrentList = currentlist.copy()
                    # add i to the copy list
                    copyCurrentList.append(i)
                    # again call the helper function
                    helper(n, copyCurrentList)

        # calling helper function ie. backtracking function for calculating the permutation list
        helper(n, currentlist)
        # print(len(result))
        return len(result)