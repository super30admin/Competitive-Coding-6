# Time Cpmplexity: O(2^n)
# Space Complexity:O(n)
class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        bool_list = [False] * (n + 1)
        self.backtrack(n, 1, bool_list)
        return self.count

    def backtrack(self, n, index, bool_list):
        if index == n + 1:
            self.count += 1
            return

        for i in range(1, n + 1):
            if i % index == 0 or index % i == 0:
                if bool_list[i] == False:
                    bool_list[i] = True
                    self.backtrack(n, index + 1, bool_list)
                    bool_list[i] = False
