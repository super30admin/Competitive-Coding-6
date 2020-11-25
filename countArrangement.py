"""
TC-O(N!) arrangements
SC-0(N) initial list

"""
class Solution:
    def countArrangement(self, N: int) -> int:
        self.count=0
        if N==0:
            self.count
        self.list1=[]
        for i in range(N):
            self.list1.append(i+1)
        self.backtrack(0,N)
        return self.count
    
    def backtrack(self,idx,N):
        #base
        if(idx==N):
            self.count+=1
            return
        
        #logic
        for i in range(idx,N):
            if(idx+1) % self.list1[i] == 0 or self.list1[i] % (idx+1) == 0:
                #action
                self.list1[idx],self.list1[i]=self.list1[i],self.list1[idx]
                #recurse
                self.backtrack(idx+1,N)
                #backtrack
                self.list1[i],self.list1[idx]=self.list1[idx],self.list1[i]
                
                
