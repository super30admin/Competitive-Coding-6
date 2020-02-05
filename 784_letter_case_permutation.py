from typing import List


class Solution:

    def __init__(self):
        self.result = []

    def letterCasePermutation(self, S: str) -> List[str]:
        """
            https://leetcode.com/problems/letter-case-permutation/
            TimeComplexity: O(2^n)
            SpaceComplexity: O(n) Recursive Stack
                'n' is the length of the string S.
        """
        if not S:
            return self.result
        self._search(list(S), 0)
        return self.result

    def _search(self, chs: list, idx: int):
        # base case
        if idx == len(chs):
            self.result.append(''.join(chs))
            return

        # logic
        self._search(chs, idx + 1)
        if chs[idx].isalpha():
            old_letter = self._letter_toggle(chs, idx)
            self._search(chs, idx + 1)
            # backtrack
            chs[idx] = old_letter

    # toggle chs[i], return the old letter for future undo
    def _letter_toggle(self, chs: list, idx: int):
        res = chs[idx]
        if chs[idx].isupper():
            chs[idx] = chs[idx].lower()
        else:
            chs[idx] = chs[idx].upper()
        return res


if __name__ == '__main__':
    h = Solution()
    print(h.letterCasePermutation("abcd"))
