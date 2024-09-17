#359
# Runs on Leetcode


class Logger:
    def __init__(self):
        self.d = {}
        
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.d:
            self.d[message] = timestamp
            return True
        else:
            time_difference = timestamp - self.d[message]
            if time_difference >= 10:
                self.d[message] = timestamp
                return True
            else:
                return False
