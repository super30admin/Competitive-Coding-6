'''
526. Beautiful Arrangement
Problem Link: https://leetcode.com/problems/beautiful-arrangement/description/
'''

# Time Complexity : O(n!) for generating all arrangements
# Space Complexity : O(n) for the recursion stack
# Did this code successfully run on Leetcode : Yes, it passed all test cases.
# Any problem you faced while coding this : Understanding the constraints for the arrangement was tricky, especially how to handle the divisibility condition.

class Solution:
    '''
    Intuition:
    We need to generate all possible arrangements of numbers from 1 to n and count how many of those arrangements are "beautiful".
    An arrangement is beautiful if for each position i (1-indexed), either the number at that position is divisible by i or i is divisible by the number at that position.
    We can use backtracking to generate all arrangements and check the condition for each arrangement.
    For this, we follow below steps:
    1. Use a backtracking approach to generate all arrangements.
    2. Use a visited array to keep track of which numbers have been used in the current arrangement.
    3. For each position, check if the number can be placed based on the divisibility condition.
    4. If we reach a position greater than n, we have found a valid arrangement, so we increment the count.
    '''
    def countArrangement(self, n: int) -> int: # humne ek function banaya hai jo beautiful arrangements ko count karega (we created a function to count beautiful arrangements)
        self.count = 0 # yeh count variable hai jo beautiful arrangements ko track karega (this count variable will track the number of beautiful arrangements)
        visited = [False] * (n + 1) # yeh visited array hai jo track karega ki kaunse numbers use ho chuke hain (this visited array will track which numbers have been used)

        def backtrack(position: int): # yeh function backtracking ke liye hai (this function is for backtracking)
            if position > n: # agar position n se zyada hai toh humne ek valid arrangement pa liya hai (if the position is greater than n, we have found a valid arrangement)
                self.count += 1 # count ko increment karo (increment the count)
                return # backtrack se bahar nikal jao (exit from backtrack)
            
            for i in range(1, n + 1): # yeh loop 1 se n tak chalega (this loop will run from 1 to n)
                if not visited[i] and (i % position == 0 or position % i == 0): # agar number use nahi hua hai aur divisibility condition satisfy hoti hai toh (if the number is not used and the divisibility condition is satisfied)
                    visited[i] = True # number ko mark karo ki use ho gaya hai (mark the number as used)
                    backtrack(position + 1) # next position ke liye backtrack karo (backtrack for the next position)
                    visited[i] = False # backtrack se pehle number ko unmark karo (unmark the number before backtracking)
        
        backtrack(1) # backtrack function ko call karo starting position 1 se (call the backtrack function starting from position 1)
        return self.count # final count return karo (return the final count)