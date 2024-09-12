#Time Complexity - O(n!) as first run of helper is called n times in worst case, then n-1 and so on..
#Space Complexity - O(n^2), one n for recursion stack and other n for each copy we get while getting the copy of list
#Works on leetcode - yes
#Approach - We use a combination of DP and recursion. We use a dictionary to keep track of intermediate results.We iterate through the tuple.
 #Whenever one or more of the required conditions get fulllfilled  for a position, we add to our count by calling helper function on N-1 and
# list(or tuple) formed by skipping the fulllfilled position. 
class Solution:
    def countArrangement(self, N: int) -> int:
        cache = {}
        def helper(x):
            if len(x)==1:
                return 1
            key = x
            if key in cache:
                return cache[key]
            total = 0
            for j in range(len(x)):
                if x[j]%len(x)==0 or len(x)%x[j]==0:
                    total += helper( x[:j]+x[j+1:])
            cache[key] = total
            return total
        return helper(tuple(range(1,N+1)))