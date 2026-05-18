class Solution:
    def countArrangement(self, n: int) -> int:
    
        self.count = 0
        self.visited = set()

        self.helper(n, 1)

        return self.count 

    def helper(self, n, index):
        
        # base
        if len(self.visited) % index != 0 and index % len(self.visited):
            return  

        if len(self.visited) == n:
            self.count = self.count +1 
            return



        # logic
        for i in range(1, n+1):
            if i not in self.visited:
                # Action
                self.visited.add(i)
                self.helper(n, i)

                #backtrack
                self.visited.remove(i)

# Time complexity: O(n!)
# Space complexity: O(n)
