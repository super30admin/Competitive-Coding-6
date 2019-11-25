# Leetcode - 784
#time - O(2 ^ N) #withut backtracking (N+N)
#space -  O(1)


class Solution(object):
    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        self.size = len(S)
        self.res = [S]
        self.helper_func(S, 0)
        return self.res

    def helper_func(self, s, idx):
        if s[idx].isdigit():
            if idx < len(s) - 1:
                self.helper_func(s, idx + 1)
        else:
            if idx == self.size - 1:
                if s[idx].isupper():
                    self.res.append(s[:idx] + s[idx].lower())
                else:
                    self.res.append(s[:idx] + s[idx].upper())

            else:
                if s[idx].isupper():  # this one to append the case which is not there in the list and if it is originally uppercase
                    self.res.append(s[:idx] + s[idx].lower() + s[idx + 1:])
                    self.helper_func(s[:idx] + s[idx].lower() + s[idx + 1:], idx + 1)

                else:  # this one to append the case which is not there in the list and if it is originally lower case
                    self.res.append(s[:idx] + s[idx].upper() + s[idx + 1:])
                    self.helper_func(s[:idx] + s[idx].upper() + s[idx + 1:], idx + 1)
                self.helper_func(s, idx + 1)  # to recurse from the next part of the original string


#another approach

class Solution(object):
    def __init__(self):
        self.res = []

    def letterCasePermutation(self, s):
        """
        :type S: str
        :rtype: List[str]
        """

        path = ""
        idx = 0
        self.backtrack(s, path, idx)
        return self.res

    def backtrack(self, s, path, idx):
        # base case
        if idx == len(s):
            self.res.append(path)  # exiting conditiong for recursion
        elif s[idx].isalpha(): # for each case 2 nes cases will be generated here ..
            self.backtrack(s, path + s[idx].upper(), idx + 1)
            self.backtrack(s, path + s[idx].lower(), idx + 1)
        else:
            self.backtrack(s, path + s[idx], idx + 1)


