# Time Complexity : O(1)
# Space Complexity : O(N) n = total number of messages
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No. Just use a map {message : time}


# Your code here along with comments explaining your approach

class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.mapping = defaultdict()

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if message not in self.mapping or timestamp - self.mapping[message] >= 10:
            self.mapping[message] = timestamp 
            return True
        else:
            return False


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)