class Solution(object):
    def countArrangement(self, n):
        # n = 3
        """
        :type n: int
        :rtype: int
        """
        if n == 1: return 1
        self.count = 0

        def helper(idx, subset):
            # base case
            if len(subset) == n:
                self.count += 1
                return
            # logc
            # 1,3 ,2
            for i in range(1, n + 1):
                # since non repeating numbers, check if number in subset or not
                if i not in subset:
                    # check if one of the conditions is met
                    if (i % idx == 0 or idx % i == 0):
                        subset.append(i)
                        # increase the idx count by 1 so we check for the next
                        helper(idx + 1, subset)
                        subset.remove(i)

        helper(1, [])
        return self.count



