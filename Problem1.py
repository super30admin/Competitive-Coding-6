# Time Complexity : O(n^2) where n is number of characters in string
# Space Complexity : O(n^2) where n is number of characters in string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        result = []

        def dfs(path, index):
            if index == len(S):
                result.append(path)
                return
            if S[index].isalpha():
                dfs(path + S[index].lower(), index + 1)
                dfs(path + S[index].upper(), index + 1)
            else:
                dfs(path + S[index], index + 1)

        dfs("", 0)
        return result

# In this problem, I am going through each of the character. If the character is alphabet then the dfs function is called
# with lower case alphabet and the upper case alphabet. If the end oof string is reached then the resultant list is returned.