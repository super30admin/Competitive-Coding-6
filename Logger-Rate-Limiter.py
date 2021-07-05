# Time Complexity: O(1)
# Space Complexity: O(m) where m is number of incoming messages
class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # Create a dictionary
        self.d = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        # If message not in dictionary, add it to dictionary and return True
        if message not in self.d:
            self.d[message] = timestamp
            return True
        # If message exists in dictionary:
        # Obtain the old timestamp
        # Compare with the new timestamp if diff is greater than or = 10
        # If yes, replace old timestamp with new and return True
        else:
            old_timestamp = self.d[message]
            if timestamp - old_timestamp >= 10:
                self.d[message] = timestamp
                return True
         # In all other cases, return False
        return False
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)