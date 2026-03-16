# Time Complexity : O(n!)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use backtracking to generate permutations. For each position (pos),
# try numbers that are not used yet and satisfy the condition:
# number % pos == 0 OR pos % number == 0.
# Mark the number as used, recurse to the next position, then backtrack.

class Solution:
    def countArrangement(self, n: int) -> int:
        def helper(arr):
            if len(arr) == n:
                self.cnt += 1
                return
            
            pos = len(arr) + 1
            
            for j in range(n):
                if not used[j] and (l[j] % pos == 0 or pos % l[j] == 0):
                    arr.append(l[j])
                    used[j] = True
                    
                    helper(arr)
                    
                    used[j] = False
                    arr.pop()

        used = [False] * n
        self.cnt = 0
        l = [i + 1 for i in range(n)]
        
        helper([])
        return self.cnt