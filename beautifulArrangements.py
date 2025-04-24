'''
Quesiton 
526. Beautiful Arrangement

TC = O(n!)
SC = O(n) - depth of recursion treecan go upto n
'''
class Solution:
    def countArrangement(self, n: int) -> int:
        
        def backTrack(pos, visited):
            if pos > n:
                return 1
            count = 0

            for num in range(1,n+1):
                if not visited[num] and (num % pos == 0 or pos % num == 0):
                    visited[num] = True
                    count += backTrack(pos+1, visited)
                    visited[num] = False
            return count

        visited = [False] * (n+1)
        return backTrack(1, visited)