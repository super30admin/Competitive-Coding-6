'''
Time Complexity: n!
Space Complexity: 0(n) -- initlize a list
Run on LeetCode: Yes
'''

class Solution:
    
    def __init__(self):
        self.__count = 0
    
    def __beautifulComboChk(self,val,size):
        if val % size == 0 or size % val == 0:
            return True
        return False
    
    def forLoopBasedRecursion(self,num,pivot,permSet,n):
        # base-case
        if len(permSet) == n:
            # I have 1 beautiful combination
            self.__count += 1
            return
        
        # logic-case
        for i in range(pivot,len(num)):
            # 1. action -- add num[i] to the set 
            if num[i] not in permSet:
                permSet.add(num[i])
            else:
                continue
            
            # 2. chk for beautifulCombo
            result = self.__beautifulComboChk(num[i],len(permSet))
            
            # 3. recurse --- conditionally
            if result == True:
                self.forLoopBasedRecursion(num,0,permSet,n)
            
            # 4. backtrack 
            permSet.remove(num[i])
    def countArrangement(self, n: int) -> int:
        
        # 1. initlize a list of numbers from 1-n
        num = []
        for i in range(1,n+1):
            num.append(i)
        
        # 2. initlize a set
        permSet = set()
        
        # 3. do recursion
        for i in range(0,len(num)):
            # 1. action --- add num[i] to the set
            permSet.add(num[i])
            
            # 2. recurse
            self.forLoopBasedRecursion(num,0,permSet,n)
            
            # 3. backtrack
            permSet.remove(num[i])
        
        # 4. chk the result 
        # print(f"Beautiful Combination count is:\t {self.__count}")
        return self.__count