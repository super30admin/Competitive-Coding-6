"""
Problem: 359. Logger Rate Limiter
Leetcode: https://leetcode.com/problems/logger-rate-limiter/
Approach: Use ordered dictionary, which inside uses double linked list to keep the order
Time Complexity: O(1). The lookup and update of the hashtable takes a constant time.
Space Complexity: O(M) where M is the size of all incoming messages. Over the time, the hashtable would have an entry for each unique message that has appeared.
"""

from collections import OrderedDict


class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.msg_dict = OrderedDict()

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        # we have seen the message before
        if message in self.msg_dict:
            # it was printed more than 10 seconds ago
            if self.msg_dict[message] <= timestamp - 10:
                self.msg_dict[message] = timestamp
                # move the message to the bottom of dictionary
                self.msg_dict.move_to_end(message)
                return True
            else:
                return False

        # remove obsolete messages
        while self.msg_dict:
            # Starting from the top-most element of the dictionary, we remove that message, if its time was before timestamp-10
            m, t = self.msg_dict.popitem(last=False)
            # if not,  it means that we are done cleaning the obsolete messages and we return the removed message to its original place as the top-most message in the OrderedDict.
            if t > timestamp - 10:
                self.msg_dict[m] = t
                self.msg_dict.move_to_end(m, last=False)
                break

        # if message not in dict
        self.msg_dict[message] = timestamp
        return True

# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)