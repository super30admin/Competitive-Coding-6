#Problem 1: Beautiful Arrangement
#Time Complexity: O(valid arrangements)
#Time Space: O(valid arrangements)
'''
We keep a memory hashset to keep track of what numbers have been used.
at one index, with iterate through all the numbers that are not in the memory.
if the number has the property that we want, we add it to memory (choose the number), call the recursion on the next index,
and pop it from memory (backtrack). If we reach the end (index=N+1), we increase
the count because it a valid arrangement.
'''

class Solution:
    def countArrangement(self, N: int) -> int:
        #edge case
        #initialisation
        count=0
        memory=set()

        def helper(index):
            nonlocal count
            #base case
            if index==N+1:
                count+=1
            #recursion
            for i in range(N):
                if i+1 in memory:
                    continue
                if (i+1)%(index)==0 or (index)%(i+1)==0:
                    memory.add(i+1)
                    helper(index+1)
                    memory.remove(i+1)
        helper(1)
        return count
