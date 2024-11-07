class Solution:
    def countArrangement(self, n: int) -> int:
        visited = set()
        count = 0

        def recursion(position):
            nonlocal count
            # base case
            if position > n:
                count += 1
                return
            # logic
            for num in range(1, n + 1):
                if num not in visited and (num % position == 0 or position % num == 0):
                    visited.add(num)
                    recursion(position + 1)
                    visited.remove(num)

        recursion(1)
        return count


# time complexity is O(n!)
# space complexity is O(n)
