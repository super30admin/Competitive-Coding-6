'''
Time: O(N!)
Space: O(N)
'''
class Solution:
    def countArrangement(self, n: int) -> int:
        self.arrangements = 0

        self.helper(n,set(),[])

        return self.arrangements
    
    def helper(self,n,visited,current_arrangement):
        # base
        # permutation check
        if len(current_arrangement)!= 0:
            if current_arrangement[-1]%len(current_arrangement)!=0 and len(current_arrangement)%current_arrangement[-1]!=0:
                return
        
        if len(current_arrangement)==n: # new arrangement
            self.arrangements+=1
            return 

        # logic
        for i in range(1,n+1):
            if i not in visited: # not yet used
                current_arrangement.append(i) # action
                visited.add(i) # action
                self.helper(n,visited,current_arrangement) # recurse
                visited.remove(i) # backtrack
                current_arrangement.pop() # backtrack
