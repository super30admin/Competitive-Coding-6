# Time Complexity : O(1) where n is total numbers
# Space Complexity : O(N*L) where L is avg size of the log message and N is number of unique log messages received
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : No

class Logger:
    def __init__(self):
        self.hashmap = {}
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.hashmap:
            if timestamp - self.hashmap[message] >= 10:
                self.hashmap[message] = timestamp
                return True
            else:
                return False
        else:
            self.hashmap[message] = timestamp
            return True