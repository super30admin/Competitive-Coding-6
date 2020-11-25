# Time Complexity: O(1)
# Space Complexity: O(n)
# Approach - Store messages with timestamp in a hashmap. Everytime shouldPrint is called check the difference in current timestamp and timestamp stored in the map. If the difference is greater than 10, return True.
class Logger(object):
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.log_map = collections.defaultdict(int)

    def shouldPrintMessage(self, timestamp, message):
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        if message in self.log_map:
            if timestamp - self.log_map[message] >= 10:
                self.log_map[message] = timestamp
                return True
            else:
                return False
        else:
            self.log_map[message] = timestamp
            return True
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)