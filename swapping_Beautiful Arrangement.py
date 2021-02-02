#time: O(m), here m refers to valid permutations
#space: O(n)

#using swapping and backtrack to calculate all valid permuations
class Solution:
    result=0
    def countArrangement(self, n: int) -> int:
        if(n==0 or n==1):
            return n
        self.result=0
        nums=[i for i in range(1,n+1)]
        index=0
        self.permutation(nums,index)
        
        return self.result
    
    def permutation(self,nums,i):
        if(i==len(nums)):
            self.result+=1
            
        for j in range(i,len(nums)):
            nums[i],nums[j]=nums[j],nums[i]
            if(nums[i]%(i+1)==0 or (i+1)%nums[i]==0):
                self.permutation(nums,i+1)
            nums[i],nums[j]=nums[j],nums[i]