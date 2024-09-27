# Did this code successfully run on Leetcode : YES

# TC: O(1)
# SC: O(N)

class Logger:

    def __init__(self):
        self.data = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.data:
            self.data[message] = timestamp
            return True
        else:
            # if differnece >= 10
            if timestamp - self.data[message] >= 10:
                self.data[message] = timestamp
                return True
            else:
                False
        