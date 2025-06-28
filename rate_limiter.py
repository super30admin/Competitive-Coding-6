# Time complexity: O(1) 
# Space complexity: O(n)

class Logger:
    def __init__(self):
        self.message_timestamps = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.message_timestamps and timestamp < self.message_timestamps[message] + 10:
            return False
        self.message_timestamps[message] = timestamp
        return True

