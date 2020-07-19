# Time Complexity : O(n^n) 
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def countArrangement(self, N: int) -> int:
        
        def backtrack(pos,temp):
            # base
            if pos < 1: 
                return 1 
            #logic
            count = 0 
            for i in range(N,0,-1): 
                if (temp[i] == False) and (pos % i == 0 or i % pos == 0):
                    temp[i] = True 
                    count += backtrack(pos-1,temp)
                    temp[i] = False 
            return count 
    
        temp = [False] * (N+1)
        return backtrack(N,temp)

if __name__ == "__main__":
    s = Solution()
    print(s.countArrangement(3))