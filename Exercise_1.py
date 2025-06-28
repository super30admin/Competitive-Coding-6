# S30 Problem #82 beautilful arrangement
#LeetCode #https://leetcode.com/problems/beautiful-arrangement/

# Author : Akaash Trivedi
# Time Complexity : O(n!)
# Space Complexity : O(h) stack space
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.res = 0
    def countArrangement(self, n: int) -> int:
        arr = []
        #creating array of initial arrrangement
        for i in range(1,n+1):
            arr.append(i)
        self.helper(n,arr,[],0)
        return self.res
    
    # path for current permutation
    def helper(self, n, arr, path, pivot):
        #base
        if len(path) == n:
            #if self.isDiv(path):
            self.res += 1
            return
        
        # current position
        pos = pivot + 1

        #logic
        for i in range(n):
            if arr[i] in path:
                continue
            
            # avoid invalid permutation before going deeper
            if arr[i] % pos != 0 and pos % arr[i] != 0:
                continue
            
            #action
            path.append(arr[i])

            #recurse
            self.helper(n,arr, path, pivot+1)

            #backtrack
            path.pop()