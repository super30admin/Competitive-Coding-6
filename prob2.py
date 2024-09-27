# Time Complexity: O(n) for queue
# Space Complexity: O(n) for queue and set
# Did this run successfully on Leetcode: Yes
# Any problem while coding this question: no
# Approach:

# use a queue to clear out expired messages as well as a set to ensure no duplicates
# when a message arrives, check if it is already in queue, if yes, then 
# if the difference of the current timestamp and the previous timestamp is greater 
# than 10, remove that element from the queue, else break from the while loop,
# and keep doing so till the queue is empty
# similarly remove the corresponding entries from the set as well

# now check if there is any duplicate for the incoming new message, 
# if the new message is not in the set, add it to the set and queue
# else return False

from collections import deque
class Logger:

    def __init__(self):
        self._msg_set = set()
        self._msg_queue = deque()
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        
        while self._msg_queue:
            
            msg, ts = self._msg_queue[0]
            if timestamp - ts >= 10:
                self._msg_queue.popleft()
                self._msg_set.remove(msg)
            else:
                break
        
        if message not in self._msg_set:
            self._msg_set.add(message)
            self._msg_queue.append((message, timestamp))
            return True
        else:
            return False