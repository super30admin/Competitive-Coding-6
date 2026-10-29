# Time Complexity : O(1)
# Space Complexity : O(M), where M is the number of unique messages.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using HashMap to store all the incoming meesages. Check if the meesage is already in HashMap if not add the message to HashMap and return True
# If the message is already in HashMap then check if current timestamp >= message[timestamp] + 10 in dict
# If yes then update the timestamp in HashMap to current timestamp and return True else return False


class Logger:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dict = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if (message in self.dict and timestamp >= self.dict[message] + 10) or message not in self.dict:
            self.dict[message] = timestamp
            return True
        return False


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)