# Time Complexity :average O(1)
# Space Complexity :O(n) all messages
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Logger(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # logger dictionary
        self.logger = {}
        

    def shouldPrintMessage(self, timestamp, message):
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        # if not found or last printer in more than 10 second update time stamo and return true else return false
        if message not in self.logger or timestamp -self.logger[message]  >= 10 :
            self.logger[message] = timestamp
            return True
        return False
        
