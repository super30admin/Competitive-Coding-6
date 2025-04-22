# Time Complexity: O(1)
# Space Complexity: O(n)
# Does this code run on Leetcode: Yes
# Did you face any problems while coding this: No

class Logger(object):
    def __init__(self):
        self.message_map = {}
    def shouldPrintMessage(self, timestamp, message):
        if message not in self.message_map:
            self.message_map[message] = timestamp
            return True
        if timestamp - self.message_map[message] >= 10:
            self.message_map[message] = timestamp
            return True
        return False