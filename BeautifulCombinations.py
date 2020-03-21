'''
Solution:
1.  This can be solved using either recursion or backtracking.
2.  Using recursion, we create a new list each time we call recursion, once choosing the element and once not choosing
    the element.
3.  Using backtracking, we update the same list we call backtracking each time and whenever we have to append the result,
    we create a copy of the list and add.

Time Complexity:    O(n!) for both the cases
Space Complexity:   O(n x n!) for recursion and O(n) for Backtracking

--- Passed all testcases on Leetcode successfully
'''


class Solution(object):

    def __init__(self):
        #   initializations
        self.finalList = []
        self.baseList = []

    def __check(self, permutation):

        #   check whether each permutation is a valid permutation or not

        for i in range(len(permutation)):
            pos = i + 1
            val = permutation[i]
            if (pos % val != 0 and val % pos != 0):
                return False

        return True

    def __helper(self, N, level, tempList):
        # base case
        if (level == N - 1):
            # if (self.__check(tempList)):
            self.finalList.append(list(tempList))
            return

        # logic
        #   iterate from current level's index + 1 to the length
        for i in range(level + 1, N):

            newList = tempList[0: level + 2]
            newList[level + 1] = tempList[i]

            #   once backtracked, the list used will be updated
            if (self.__check(newList)):
                for j in range(level + 1, i):
                    newList.append(tempList[j])
                for j in range(i + 1, N):
                    newList.append(tempList[j])

                self.__helper(N, level + 1, newList)

    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """

        #   create a base list that will be updated while backtracking
        self.baseList = [i for i in range(1, N + 1)]

        #   creating n times at level 0 of the recursion tree
        for i in range(N):
            newList = [self.baseList[i]]
            for j in range(i):
                newList.append(self.baseList[j])
            for j in range(i + 1, N):
                newList.append(self.baseList[j])
            self.__helper(N, 0, newList)

        #   length of the final list
        return len(self.finalList)