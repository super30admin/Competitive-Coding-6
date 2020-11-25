#Time Complexity : O(p) where p is the number of permutations which are valid
#Space Complexity : O(n) where n is the given length
#Did this code successfully run on Leetcode : Yes


class Solution:
    def helper(self, temp, index):
        #base
        if index == len(temp):
            self.result += 1

        #logic
        #make all permutations
        for i in range(index, len(temp)):
            temp[i], temp[index] = temp[index], temp[i] #action
            if temp[index] % (index+1) == 0 or (index + 1) % temp[index] == 0: #check if new swap satisfies the beautiful arrangement conditions
                self.helper(temp, index+1) #recurse
            temp[index], temp[i] = temp[i], temp[index] #backtrack


    def countArrangement(self, N: int) -> int:
        self.result = 0
        temp = []
        #temp = [1,2]
        for i in range(1, N+1):
            temp.append(i)

        self.helper(temp, 0)

        return self.result
