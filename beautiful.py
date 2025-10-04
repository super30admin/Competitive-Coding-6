# Time Complexity : O(N!) where N is the number of elements in the array
# Space Complexity : O(N) where N is the number of elements in the array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am handling a case where n = 1 and returning 1 as there is only one way to arrange one element.
# I am creating a counter variable to keep track of the number of beautiful arrangements.
# I am creating a visited array to keep track of the elements that have been used in the current arrangement.
# I am using a helper function to perform backtracking.
# The helper function takes the current index as input.
# If the current index is greater than or equal to n, I increment the counter variable and return.
# I iterate through the elements from 1 to n.
# For each element, I check if it has not been visited and if it is divisible by the current index or if the current index is divisible by the element.
# If both conditions are met, I mark the element as visited and call the helper function recursively with the next index.
# After the recursive call, I mark the element as unvisited to backtrack and try other elements.
# Finally, I return the counter variable.


class Solution:
    def countArrangement(self, n: int) -> int:
        if n == 1:
            return 1
        self.counter = 0
        vis = [False for _ in range(n+1)]
        
        def helper(idx):
            if idx >= n:
                self.counter += 1
                return 

            for i in range(1,n+1):
                # print(i)
                if not vis[i] and (idx % i == 0 or i % idx == 0):
                    vis[i] = True
                    helper(idx+1)
                    vis[i] = False
        helper(1)
        return self.counter
            


            


        