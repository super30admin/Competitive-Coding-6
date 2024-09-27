# Did this code successfully run on Leetcode : YES

# TC: O(N^N)
# SC: O(N)

class Solution:
    
    def countArrangement(self, n: int) -> int:
        result = 0

        
        def helper(cnt=0, visited=[False for _ in range(n)]):
            if cnt > n:
                return
            if cnt == n:
                nonlocal result
                result += 1
                return
            for i in range(1, n+1):
                if not visited[i-1] and ((i%(cnt+1) == 0) or ((cnt+1)%i == 0)):
                    visited[i-1] = True
                    cnt += 1
                    helper(cnt, visited)
                    visited[i-1] = False
                    cnt -= 1
                    
        helper()
        return result