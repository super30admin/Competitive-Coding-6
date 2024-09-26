'''
Time Complexity: O(n!)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a state array to keep track of state changes and a set to make sure we add the element only once,
use the index in the recursive call to keep track of the current index in the state array and check if
(array[i] % (index) == 0 or index % array[i] == 0) if this is true only then we backtrack and the index is an
accepted beautiful solution.
'''
class Solution:
    def __init__(self):
        self.count = 0

    def backtrack(self, state: list, index, array, check):

        if len(state) == len(array):
            self.count += 1

        for i in range(0, len(array)):
            if array[i] not in check and (array[i] % (index) == 0 or index % array[i] == 0):
                state.append(array[i])
                check.add(array[i])
                self.backtrack(state, index + 1, array, check)
                check.remove(array[i])
                state.pop()

    def countArrangement(self, N: int) -> int:
        array = [x for x in range(1, N + 1)]

        self.backtrack([], 1, array, set())

        return self.count