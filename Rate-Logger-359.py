# Time Complexity : O(1) get in hashmap
# Space Complexity : O(n) no of messages
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#create a map to update and get value
class Logger(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.res = {}

    def shouldPrintMessage(self, timestamp, message):
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        if message not in self.res:
            self.res[message] = timestamp
            return True
        
        if timestamp - self.res[message] >= 10:
            self.res[message] = timestamp
            return True
        else:
            return False
            