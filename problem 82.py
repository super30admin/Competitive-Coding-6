#  https://leetcode.com/problems/beautiful-arrangement/ 



# Time Complexity : O(n! * n) # for each arrangement, where n is the number of elements in the array
# Space Complexity : O(n) # to store visited numbers and the current arrangement
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        self.visited = [False] * (n+1) # a visited list to track which numbers have been placed in the arrangement
        self.helper(n,1)
        return self.count

    def helper(self,n,pivot):
        # base
        if (pivot>n): # if the pivot is greater than n, all positions are filled, count this arrangement
            self.count+=1
            return
        
        #logic
        # try placing each number in the current position (pivot)
        for i in range(1,n+1):
            # Check if the number i is not yet used and satisfies the divisibility condition
            if(not self.visited[i] and (pivot % i == 0 or i % pivot == 0 )):
                self.visited[i] = True
                self.helper(n,pivot+1) # Recursively call helper function to try placing the next number at position pivot+1
                self.visited[i] = False # backtrack if it is not the solution to the current position


