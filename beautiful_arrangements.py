class Solution(object):
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        if N==0:
            return
        self.count=0
        def helper(start):
            if start==0:
                self.count+=1
                return
            for i in range(start,0,-1):
                self.nums[i],self.nums[start]=self.nums[start],self.nums[i]
                #same as permutations
                #just add extra check condition
                if self.nums[start]%start==0 or start%self.nums[start]==0:
                    helper(start-1)
                self.nums[i],self.nums[start]=self.nums[start],self.nums[i]
        self.nums=range(N+1)
        helper(N)
        return self.count