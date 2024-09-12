# Time Complexity : O(n) where n is number of meetings
# Space Complexity : O(n) where n is number of meetings
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No




"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""
import operator
import heapq


class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: the minimum number of conference rooms required
    """

    def minMeetingRooms(self, intervals):
        # Write your code here
        if len(intervals) == 0:
            return 0
        heap = []
        inter = []
        for i in intervals:
            inter.append((i.start, i.end))
        sorted(inter, key=operator.itemgetter(0))

        heapq.heappush(heap, inter[0][1])

        for i in range(1, len(inter)):
            heap_element = heapq.heappop(heap)
            if inter[i][0] > heap_element:
                heapq.heappush(heap, inter[i][1])
                heapq.heapify(heap)
            else:
                heapq.heappush(heap, inter[i][1])
                heapq.heappush(heap, heap_element)
                heapq.heapify(heap)
        return (len(heap))

# Here I have used heap. I have initially sorted the meetinggs according to the start time. The I am inserterting the
# endtimes of meetings in the heap. If start time of any meeting is after endtime of a meeting than the value of that heap
# node is inreased else a new node is inserted which represents a new room.