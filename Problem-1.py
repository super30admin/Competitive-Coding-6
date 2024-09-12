"""
Approach: The goal is to generate all permutations and at each one of the them check if the give 2 conditions satisfy
1) Since you cannot repeat the numbers make use of a visited array to mark if a number has been visited already
2) Do  for loop DFS then a) make the number visited b) traverse to find the next number/value c) backtrack and mark the
    number as not visited

TC: O(n^n). Can also say O(n!)
SC: O(n). Auxiliary storage = visited + recursion stack
"""
class Solution:
    def __init__(self):
        self.count = 0
    def countArrangement(self, n: int) -> int:
        visited = [False ] *( n +1)
        self.backtrack(n, 1, visited)
        return self.count

    def backtrack(self, n, index, visited):
        # base
        if index == n+ 1:
            self.count += 1
            return

        # logic
        for value in range(1, n + 1):
            if visited[value]:
                continue
            if index % value == 0 or value % index == 0:
                # action
                visited[value] = True
                self.backtrack(n, index + 1, visited)
                # backtrack
                visited[value] = False