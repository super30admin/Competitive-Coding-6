"""
The approach here is to use priority queue, we sort the array based on the start times,and now we store
the first index end time in the heap, now we iterate through the array and check if the start times are
smaller than the 0th index element in the heap id so we push the end time of the current index, if not 
we pop the element from the heap and push the current element end time.
Time complexity - O(N^2)
Space complexity - (N)
"""

def minMeetingRooms(self, intervals):
        if len(intervals) == 0:
            return 0
        intervals = sorted(intervals, key = lambda x: x.start)
        import heapq
        heap = []
        heapq.heappush(heap, intervals[0].end)
        for i in range(1, len(intervals)):
            if intervals[i].start < heap[0]:
                heapq.heappush(heap, intervals[i].end)
            else:
                heapq.heappop(heap)
                heapq.heappush(heap, intervals[i].end)
        return len(heap)