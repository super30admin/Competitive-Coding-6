#LC 526 - Beautiful Arrangement
#Time Complexity - O(2^n)
#Space Complexity - O(n)
class Solution(object):
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        vis = set()
        self.count = 0
        def backtrack(i,path,vis,index):
            #base
            if index > N:
                self.count = self.count + 1
                return
            #action
            for i in range(1,N+1):
                if i not in vis:
                    if i % index == 0 or index % i == 0:
                        vis.add(i)
                        path.append(i)
                        backtrack(i+1,path,vis,index+1)
                        path.pop()
                        vis.remove(i)
                        #index = index - 1
        backtrack(1,[],vis,1)
        return self.count
            