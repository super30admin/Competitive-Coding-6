#Time Complexity : O(1) 
#Space Complexity : O(n) where n is the total number of messages coming in
#Did this code successfully run on Leetcode : Yes

class Logger:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.logger = dict()

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if message in self.logger:
            if timestamp-self.logger[message] < 10:
                return False

        self.logger[message] = timestamp
        return True
