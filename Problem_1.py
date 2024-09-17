"""
Time Complexity : O(n!) - As at each level, the number of possible values are decreasing
Space Complexity : O(n) - for the visited set
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
For this solution, the bruteforce would be to find all the combinations and check for the conditions. A better approach would be 
to continue only if the conditions are valid. This would save a lot of time. To save some more time, a better approach would be
to start from N rather to start from 1 as if we start from 1, a lot of times, smaller numbers would be divisible by the the positions
or vice versa, but the condition wont work in case of bigger numbers. Hence, starting from back would be a better approach.
"""


class Solution:
    def countArrangement(self, N: int) -> int:
        self.v = set()
        self.count = 0
        self.calc(N, N)
        return self.count

    def calc(self, pos, N):
        if pos < 1:
            self.count += 1

        for i in range(N, 0, -1):
            if (i not in self.v and (pos % i == 0 or i % pos == 0)):
                self.v.add(i)
                self.calc(pos-1, N)
                self.v.remove(i)
