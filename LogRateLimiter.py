"""
Time Complexity : O(1)
Space Complexity : O(n) where n is my incoming messsages
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.mainDict = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if message not in self.mainDict:
            self.mainDict[message] = timestamp
            return True
        if timestamp - self.mainDict[message] >= 10:
            self.mainDict[message] = timestamp
            return True
        else:
            return False


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)