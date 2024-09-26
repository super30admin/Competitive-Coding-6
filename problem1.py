#beautiful arrangement
# // Time Complexity : O(N!)?
# // Space Complexity : O(N) 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def countArrangement(self, n: int) -> int:
        self.counts=0
        arr=[False]*(n+1)               #create a list of n+1 elements with all false value
        pp=[0]*(n+1)
        
        def helper(index, n):
            #base
            if(index>n):
                self.counts+=1                  #everytime the index gets bigger than the list, add the counter by 1
                return
            
            #action
            
            for i in range(1, n+1):                                 #do the recursion on the every elements of the list everytime you move index
                if(arr[i]==False and (index%i==0 or i%index ==0)):      #if the array is false and its  divisible by the index or the index is  divisible by the number, then set its value to true and call the function on the next index
                    arr[i]=True
                    helper( index+1, n)
                    arr[i]=False
                    
        helper(1, n )
        return self.counts

print(Solution().countArrangement(3))
