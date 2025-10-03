class Solution(object):
    # tc : O(k) where k is the valid pairs
    # sc : 2O(n) O(n) to create the array, O(n) the recrussive stack space 
    def countArrangement(self, n):
        """
        :type n: int
        :rtype: int
        """
        # intution 
        #  start with an array of numbers from 1 to n.
        # Generate all permutations recursively by swapping elements from the current pivot to the end.
        # Prune early: If the current number at the pivot position doesn’t satisfy the "beautiful" condition, skip further recursion for that branch.
        # Count valid arrangements whenever the pivot reaches the end.

        self.count = 0
        arr = [i for i in range(1,n+1)] # 1-indexed 

        self.helper(arr,0)

        return self.count


    def helper(self,arr,pivot):

        # base conditin
        if pivot == len(arr): 
            self.count+=1 
            return

        # action 
        for i in range(pivot,len(arr)): # swap pivot element with i lets take [1,2,3] pivot at index 1, so the permutations are 1 swapped with 1, 1,2,1,3
        # once swapped a new array is frmed and we check [2,1,3] satisfy the beautiul terms 
            arr[i], arr[pivot] = arr[pivot] , arr[i]

            # check condition
            if arr[pivot]%(pivot+1) == 0 or (pivot+1 )%arr[pivot] == 0 : # if satisfied then we further process swappign this combination [2,1,3] - gives[2,1,3] [ 2,3,1] swaps from pivot to end if 2,1,3 failes to satisy we dont further do recursion as this fails this branch recurssion also fails so no need to do recrussion of it 
              self.helper(arr,pivot+1)

            # backtrack
            arr[i], arr[pivot] = arr[pivot] , arr[i] # once [2,1,3] is processed we need to und the swao making it [1,2,3] and the for loop will sawp the pivot at 0 and i at 2 as i at 1 is processed 

