# The approach uses backtracking to generate all valid permutations of numbers from 1 to n, 
# ensuring that the condition i % position == 0 or position % i == 0 is satisfied. 
# It recursively explores each position, counting valid arrangements when all positions are filled.

# Time Complexity:
# Time Complexity: O(n!), since the function explores all permutations of n numbers.
# Space Complexity: O(n), due to the recursive call stack and the visited array.
class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        visited = [False] * (n + 1)
        self.calculate(n, 1, visited)
        return self.count

    def calculate(self, n, position, visited):
        if position > n:
            self.count += 1
            return
        for i in range(1, n + 1):
            if not visited[i] and (i % position == 0 or position % i == 0):
                visited[i] = True
                self.calculate(n, position + 1, visited)
                visited[i] = False