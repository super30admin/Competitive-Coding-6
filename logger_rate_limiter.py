# O(1) TIME AND O(1) SPACE

class Logger:
    def __init__(self):
        self.tracker = {}
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.tracker or timestamp - self.tracker[message] >= 10:
            self.tracker[message] = timestamp
            return True
        else:
            return False