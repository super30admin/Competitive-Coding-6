# TC : O(exponential)
# SC : O(N) - Number of elements max stack height
class Solution:
    def countArrangement(self, n: int) -> int:
        self.res = 0
        
        def condition(ele , index):
            if ele % index == 0 or index%ele == 0:
                return True
            else:
                return False
        
        nums = [i for i in range(1, n+1)]
        
        def swapPos(l, pos1, pos2):
            l[pos1], l[pos2] = l[pos2], l[pos1]

        def recur(nums ,index):
            # BASE
            if (index == len(nums)):
                self.res+=1;
            
            #LOGIC
            for i in range(index,len(nums)):
                swapPos(nums, i, index);
                if (nums[index] % (index + 1) == 0 or (index + 1) % nums[index] == 0):
                    recur(nums, index + 1);
                swapPos(nums, i, index);
   
    
        recur(nums, 0)
        return self.res
                    
            
        
