# time complexity: O(k) where k is the number of valid permutations, worst case O(n!)
# space complexity: O(n)
# approach: This solution uses a backtracking algorithm to count the number of "beautiful arrangements" of numbers from 1 to n. Starting from position 1, we attempt to place each number at each position. For a placement to be valid, the number at position pos must satisfy the condition: num % pos == 0 or pos % num == 0. If valid, we mark the number as used, continue to the next position, and then backtrack by removing the number from the set.

class Solution:
    def countArrangement(self, n: int) -> int:
        
        def backtrack(pos, used):
            # base case
            if pos>n:
                return 1

            count = 0
            # logic
            for num in range(1, n+1):

                if num in used:
                    continue

                if num%pos==0 or pos%num==0:
                    used.add(num)
                    count += backtrack(pos+1, used)
                    # backtrack
                    used.remove(num)
            return count


        return backtrack(1, set())