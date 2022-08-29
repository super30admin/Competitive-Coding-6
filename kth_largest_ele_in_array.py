# Approach 1
# Time Complexity : O(nlogn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
 

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        nums.sort()
        for i in range(k):
            max = nums.pop()
        return max

      
      
#Approach 2 
# Time Complexity : O(nlogk)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from queue import PriorityQueue

class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        queue = PriorityQueue()
        for i in nums:
            queue.put(i)
            if queue.qsize() > k:
                queue.get()
        return queue.get()
