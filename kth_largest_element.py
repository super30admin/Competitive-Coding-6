# Time Complexity : O(n*log(k))
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
from queue import PriorityQueue


class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        queue = PriorityQueue()
        for i in nums:
            queue.put(i)
            if queue.qsize() > k:
                queue.get()
        return queue.get()


print(Solution().findKthLargest([3, 2, 1, 5, 6, 4], 2))


# O(n*log(k))
# import heapq
#
#
# class Solution:
#     def findKthLargest(self, nums: list[int], k: int) -> int:
#         result = []
#         for i in nums:
#             heapq.heappush(result, i)
#             if len(result) > k:
#                 heapq.heappop(result)
#         return result[0]
#
#
# print(Solution().findKthLargest([3, 2, 1, 5, 6, 4], 2))


# O(n*log(n))
# class Solution:
#     def findKthLargest(self, nums: List[int], k: int) -> int:
#         nums.sort()
#         for i in range(k):
#             max = nums.pop()
#         return max
#
#
# print(Solution().findKthLargest([3, 2, 1, 5, 6, 4], 2))



