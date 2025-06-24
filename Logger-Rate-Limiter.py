class Logger:
    def __init__(self):
        self.lastTime = dict()
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.lastTime and timestamp - self.lastTime[message] < 10:
            return False
        self.lastTime[message] = timestamp
        return True