"""

    Student : Shahreen Shahjahan Psyche
    Time: O(n!) [Cause I am checking all the permutations of the number set]
    Space: O(n) [As I am using a set to store the values and it reaches highest N numbers. Also, in stackspace too!]

    Passed LC: Yes

"""

class Solution:
    
    def __init__(self):
        
        self.count = 0
    
    # checking whether the current number validates the constraints
    def isvalid(self, num, index):
        if num%index == 0 or index%num == 0:
            return True
        return False
    
    def helper(self, beautiful, index, track):
        # base case
        if len(track) == len(beautiful):
            self.count += 1
        
        for i in range(len(beautiful)):
            # if my number is not in the current set and it validates the constraint then I am adding the number to the set and pushing it 
            # into the stack space
            if beautiful[i] not in track and self.isvalid(beautiful[i], index):
                track.add(beautiful[i])
                self.helper(beautiful, index+1, track)
                track.remove(beautiful[i])
            
    def countArrangement(self, N: int) -> int:
        
        from collections import deque
        
        beautiful = [(i+1) for i in range(N)]
        print(beautiful)
        index = 1
        track = set()
        
        self.helper(beautiful, index, track)
        
        return self.count
        
        