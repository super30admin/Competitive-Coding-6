// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we try to generate all the permutations for the given number n and from that if any permutation is having the property of beautiful arrangement then we say that it is a valid beautiful arrangement.

Time complexity --> o(k) no of valid permutations
space complexity --> o(n) no of integers in the given input.

class Solution(object):
    def __init__(self):
        self.count=0
    
    def backtrack(self,result,index):
        # print(index,result)
        if  index==len(result):
            self.count+=1
        
        for i in range(index,len(result)):
            #we perform swapping to get different permutations
            result[i],result[index]=result[index],result[i]
            if result[index]%(index+1)==0 or (index+1)%result[index]==0:
                self.backtrack(result,index+1)
            #backtracking by reversing to its normal position
            result[index],result[i]=result[i],result[index]
    
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        result=[]
        for i in range(1,N+1):
            result.append(i)
        self.backtrack(result,0)
        return self.count
        