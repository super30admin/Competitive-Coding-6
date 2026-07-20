#https://leetcode.com/problems/beautiful-arrangement/
# # Time Complexity: O(n!) At position 1 we have up to n choices, at position 2 up to n-1 remaining choices and so on,so the recursion tree has up to n x (n-1) x ... x 1 leaves, which is n factorial.
# Space Complexity: O(n) The visit list holds n+1 booleans, which is O(n).
# The recursion goes at most n levels deep because pos increases by one each call, so the call stack is also O(n).
# Both are O(n), so the total is O(n).
# Approach:
# We build the arrangement one position at a time, starting from position 1.
# At each position we try every number from 1 to n that is still unused and satisfies the divisibility rule,mark it used, recurse to the next position, then unmark it so other choices can be tried.
# When pos goes past n it means we filled every position successfully, so we count that as one beautiful arrangement.

class Solution:
    def countArrangement(self, n: int) -> int:
        self.visit = []                              # placeholder, gets replaced on the line below
        self.count = 0                               # running total of complete beautiful arrangements found

        self.visit = [False]*(n+1)                   # tracks which numbers are already used, size n+1 so index i means number i and index 0 is unused
        self.helper(n,1)                             # start building from position 1, since positions are 1 indexed
        return self.count                            # after all branches are explored, this holds the final answer
    
    def helper(self, n,pos):
        if pos > n:                                  # we went past the last position, meaning every position got a valid number
            self.count +=1                           # so this is one complete beautiful arrangement
            return                                   # stop and go back up to try other choices
        
        for i in range(1, n+1):                      # try every number from 1 to n as the candidate for this position
            # take this number only if it is unused and it fits the rule: number divides position or position divides number
            if not self.visit[i] and (i% pos ==0 or pos % i ==0):
                self.visit[i]=True                   # mark the number as used so deeper calls cannot reuse it
                self.helper(n,pos+1)                 # move on and fill the next position
                self.visit[i]= False                 # backtrack: free the number again so the next candidate can be tried here

        
        