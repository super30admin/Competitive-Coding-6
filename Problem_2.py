# https://leetcode.com/problems/logger-rate-limiter/description/

class Logger:

    def __init__(self):
        self.map = {}

    def shouldPrintMessage(self, timestamp, message):
        if message not in self.map:
            self.map[message] = timestamp
            return True
        ts = self.map[message]
        if ts + 10 <= timestamp:
            self.map[message] = timestamp
            return True
        return False


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)
