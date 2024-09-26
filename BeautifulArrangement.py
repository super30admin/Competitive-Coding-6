class Solution:
    """using recursion, backtracking
    Time complexity-O(n!) as for n numbers, we will n! permutations
    Space O(n) for array as we are using backtracking(it would only contsin elements till n), no need to initialize array at the start of each element"""
    def __init__(self):
        self.result=[]
        self.count=0
        
    def countArrangement(self, n: int) -> int:
        arr=[]
        for i in range(1, n+1):
            self.permutation(i,arr, n)
        return self.count
        
    def permutation(self, i, arr, n):
        if len(arr)%i!=0 and i%len(arr)!=0:
            return
        if len(arr)==n:
            self.count+=1
            return
        if i not in arr:
            arr.append(i)
            self.permutation(i, arr, n)
            arr.remove(i)
        if arr:
            for i in range(1, n+1): 
                if i not in arr:
                    arr.append(i)
                    self.permutation(i, arr, n)
                    arr.remove(i)
#     def __init__(self):
#         self.result=[]
#         self.count=0
        
#     def countArrangement(self, n: int) -> int:
#         arr=[]
#         self.permutation(1,arr, n)
#         return self.count
        
#     def permutation(self, i, arr, n):
#         if len(arr)%i!=0 and i%len(arr)!=0:
#             return
#         if len(arr)==n:
#             self.count+=1
#             return

#         for j in range(1, n+1):
#             if j not in arr:
#                 arr.append(j)
#                 self.permutation(j, arr, n)
#                 arr.remove(j)
                
#         arr=[]
#         count=0
        
#         def permutation(i):
#             nonlocal count
#             if len(arr)%i!=0 and i%len(arr)!=0:
#                 return
#             if len(arr)==n:
#                 count+=1
#                 return

#             for j in range(1, n+1):
#                 if j not in arr:
#                     arr.append(j)
#                     permutation(j)
#                     arr.remove(j)
#         permutation(1)
#         return count
       
        """Ran till input 9"""
#     def __init__(self):
#         self.result=[]
#         self.count=0
        
#     def countArrangement(self, n: int) -> int:
#         arr=[]
#         self.helper(n, arr)
#         return self.count
    
#     def helper(self, n, arr):
#         self.permutation(n, arr)
#         for i in range(len(self.result)):
#             self.checkCondition(i, n)
        
#     def checkCondition(self, i, n):
#         for j in range(n):
#             if self.result[i][j]%(j+1)!=0 and (j+1)%self.result[i][j]!=0:
#                 return
#         self.count+=1
        
#     def permutation(self, n, arr):
        
#         if len(arr)==n:
#             self.result.append(arr[:])
#             return
#         for i in range(1,n+1):
#             if i not in arr:  
#                 # copy=arr[:]
#                 arr.append(i)
#                 self.permutation(n, arr)
#                 arr.pop()
        
        