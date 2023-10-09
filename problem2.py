# TC: O(1)
# SC: O(N)

class Logger:

    def __init__(self):
        self.d = collections.defaultdict()
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.d:
            self.d[message] = timestamp
            return True
        elif timestamp - self.d[message] >= 10:
            self.d[message] = timestamp
            return True
        else:
            return False
            