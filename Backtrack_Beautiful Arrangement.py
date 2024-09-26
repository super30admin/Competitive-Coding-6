#time: O(m). here m refers to valid permutations
#space: O(n)

#using backtrack
class Solution:
    result=0
    def countArrangement(self, n: int) -> int:
        if(n==0 or n==1):
            return n
        self.result=0
        nums=[]
        visited={}
        self.permutation(nums,visited,n)
        
        return self.result
    
    def permutation(self,nums,visited,n):
        if(len(nums)==n):
            self.result+=1

        for j in range(1,n+1):
            if(j not in visited):
                nums.append(j)
                visited[j]=1
                if(j%len(nums)==0 or len(nums)%j==0):
                    self.permutation(nums,visited,n)
                nums.remove(j)
                visited.pop(j)