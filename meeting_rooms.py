"""
Given a set of start and end tuples find the minimum number of meeting rooms required for
hosting all the meetings

Time Complexity = O(NlogN) {time to sort the input}
Space Complexity O(N)

"""

"""
Solution 1 with stacks .
"""


def meeting_rooms_1(timings):
    starts = sorted([t[0] for t in timings])
    ends = sorted([t[1] for t in timings ])
    meeting_rooms_occupied = 0
    max_meeting_rooms_occupied = 0
    while starts :
        if starts[0] > ends[0] :
            meeting_rooms_occupied -= 1
            ends = ends[1:]
        elif starts[0] == ends[0] :
            ends = ends[1:]
            starts = starts[1:]
        else :
            meeting_rooms_occupied += 1
            max_meeting_rooms_occupied = max(max_meeting_rooms_occupied,meeting_rooms_occupied)
            starts = starts[1:]
    return max_meeting_rooms_occupied



"""
Solution 2 with priority queue
"""


def add(s, queue):
    if not queue:
        queue.append(s)
        return
    head = filter(lambda x: x < s, queue)
    return head + [s] + queue[len(head):]


def meeting_rooms_2(timings):
    sorted_timings = sorted(timings, key=lambda x: x[0])
    queue = []
    max_size = 0
    for i in sorted_timings:
        if (not queue) or (i[0] > queue[0]):
            queue = queue[1:]
        add(i[1], queue)
        max_size = max(max_size, len(queue))
    return max_size
