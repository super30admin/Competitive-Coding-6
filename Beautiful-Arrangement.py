# Time Complexity: O(n!)
# Space Complexity: O(n)
class Solution:
    # Maintain a global count variable to count the number of arrangements
    def __init__(self):
        self.count = 0
    
    def validate(self, arr, index, n):
        # Increment count whenever the index is greater than n
        if index > n:
            self.count += 1
        
        # Loop through all the elements in the array starting from 1
        for i in range(1,len(arr)):
            # Check if the position at i in array is false
            if arr[i] == False: 
                # Check the condition that the number mod index and index mod number is zero for a beautiful arrangement
                if index % i == 0 or i % index == 0:
                    # action: Make the element in the array at index i as True
                    arr[i] = True
                    # recurse from the next index
                    self.validate(arr, index + 1, n)
                    # backtrack and make the element in the array at index i as False
                    arr[i] = False
    
    def countArrangement(self, n: int) -> int:
        # Base condition check
        if n <= 0:
            return 0
        
        # Take an array of size n+1 size the numbers start from 1
        arr = [False]*(n+1)
        self.validate(arr, 1, n)
        return self.count
        
        