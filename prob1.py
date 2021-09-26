# Time Complexity: O(n!)
# Space Complexity: O(H)
# Did this run successfully on Leetcode: Yes
# Any problem while coding this question: Took some time to realise I have to use visited array
# Approach:

# use a visited array of size (n+1) and in a for loop 
# if that position 'pivot' is not visited and pivot % i == 0 or
# i % pivot == 0, make visited[pivot] = True
# else backtrack, i.e, make visited[pivot] = False
# increment count when pivot > n
# and return count


class Solution:
    count = 0
    def countArrangement(self, n: int) -> int:
        global count
        count = 0
        if n <= 0:
            return count
        visited = [False] * (n+1)
        self.helper(n, 1, visited)
        return count


    def helper(self, n, pivot, visited):
        global count
        if pivot > n:
            count += 1
        for i in range(1, n+1):
            if not visited[i] and (pivot % i == 0 or i % pivot == 0):
                visited[i] = True
                self.helper(n, pivot + 1, visited)
                visited[i] = False

obj1 = Solution()
print('n=2 -->', str(obj1.countArrangement(2)))
print('n=3 -->', str(obj1.countArrangement(3)))
print('n=4 -->', str(obj1.countArrangement(4)))
print('n=5 -->', str(obj1.countArrangement(5)))