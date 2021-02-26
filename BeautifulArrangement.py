# Time Complexity : O(N!)
# Space Complexity : O()
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Using Backtracking. Initialize a set with the incoming element i
# Check if i is not in set then add it to set and call the recursive function to check if the lenght of set is divisible by i or i is divisible by length of set
# If either of the conditions are not satisfied then we return to the functional call and backtrack that is remove i and check other possible permutations
# If either of condition is satisfied we procees and check if the length of set is equal to n and increment the count by 1 and check other permutations until all are finished


class Solution:
    def countArrangement(self, n: int) -> int:
        self.visited = set()
        self.count = 0
        self.backtrack(1, n)
        return self.count

    def backtrack(self, i, n):
        #base
        if len(self.visited) % i != 0 and i % len(self.visited) != 0:
            return
        if len(self.visited) == n:
            self.count += 1
            return

        #logic
        for i in range(1, n + 1):
            if i not in self.visited:
                #action
                self.visited.add(i)
                #recurse
                self.backtrack(i, n)
                #backtrack
                self.visited.remove(i)
