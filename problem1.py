#Time Complexity :O(1)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :No

class Logger:

    def __init__(self):
        self.result = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.result:
            if timestamp - self.result[message] >= 10:
                self.result[message] = timestamp
                return True
            else:
                return False
        else:
            self.result[message] = timestamp
            return True