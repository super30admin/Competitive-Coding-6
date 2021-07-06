"""
Approach:
1) use a hashmap to store all valid logs. Note: We need to make sure that only the valid logs go into hashmap.
    we can use this data as the comparison data to check if the new logs are valid or not
2) If the new log has been seen already, its timestamp should be at least 10 seconds ahead of the exiting log

TC: O(1) for each new message/log
SC: O(n) where n is the number of valid logs seen previously
"""
class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashmap = {}


    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if message not in self.hashmap:
            self.hashmap[message] = timestamp
            return True
        elif timestamp - self.hashmap[message] >= 10:
            self.hashmap[message] = timestamp
            return True
        return False

# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)