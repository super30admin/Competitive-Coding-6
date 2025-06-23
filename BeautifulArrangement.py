
# // Time Complexity : o(k) where k is the no of valid permutations
# // Space Complexity : o(n) visited array where n is the number of elements or depth of recursion
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# the idea is to place the numbers from 1 to n at all positions and check if a valid arrangement is possible by placing them there . If it is possible place them in array and then check other positon
# after placing the element also place them in visited so that if we are trying to place the same element again we can just ignore them 
# once  a path is completed or we have placed all elements or pos = n+1 then increase the count and remove the elenment from that path backtrack and again find the path


class Solution:
    def countArrangement(self, n: int) -> int:
        count, visited = 0, set() 
        def helper(n,visited, pos):
            nonlocal count
            #base 
            if pos == n+1: count+=1
            #logic 
            for i in range(1, n+1): 
                # can number i be fixed to position pos ? 
                if (i in visited) or (i%pos!= 0 and pos%i != 0 ): continue 
                visited.add(i)
                helper(n, visited, i+1)
                visited.remove(i)
        helper(n,visited, 1)
        return count         